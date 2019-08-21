package server;

import client.Controller;
import client.Main;
import javafx.stage.Stage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientHandler {
    private Server server;
    private Socket socket;
    DataInputStream in;
    DataOutputStream out;
    String nick;

    public ClientHandler(Server server, Socket socket) {
        try {
            this.server = server;
            this.socket = socket;
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());

//            System.out.println("socket.getPort() "+ socket.getPort());
//            System.out.println("socket.getLocalPort() "+socket.getLocalPort());
//
//            System.out.println("socket.getInetAddress() "+socket.getInetAddress());
//            System.out.println("socket.getLocalSocketAddress() "+socket.getLocalSocketAddress());
//            System.out.println("socket.getRemoteSocketAddress() "+socket.getRemoteSocketAddress());


            new Thread(() -> {
                try {
                    // цикл авторизации
                    while (true) {
                        String str = in.readUTF();
                        if (str.startsWith("/auth ")) {
                            String[] token = str.split(" ");
                            String newNick = AuthService.getNickByLoginAndPass(token[1], token[2]);
                            if (newNick != null & server.authorizationError(newNick)) {
                                sendMSG("/authok");
                                nick = newNick;
                                server.subscribe(this);
                                server.broadcastMsg("Клиент " + nick + " авторизовался");
                                this.sendMSG("Сейчас онлайн : " + server.status());
                                break;
                            } else {
                                if (!server.authorizationError(newNick)) sendMSG("Этот пользователь уже в сети!");
                                else sendMSG("Неверный логин / пароль");
                            }
                        }
                    }
                    //цикл работы
                    while (true) {
                        String str = in.readUTF();
                        if (str.equals("/end")) {
                            break;
                        }
                        if (str.startsWith("/w ")) {
                            String[] s = str.split(" ", 3);
                            server.privateMsg(s[1], nick + " шепчет Вам: " + s[2]);
                        } else server.broadcastMsg(nick + " : " + str);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    server.unsubscribe(this);
                    System.out.println("Клиент " + nick + " отключился");
                }
            }).start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMSG(String msg) {
        try {
            out.writeUTF(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}