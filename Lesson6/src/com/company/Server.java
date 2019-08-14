package com.company;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    static DataInputStream inputStream;
    static DataOutputStream outputStream;
    static Socket socket = null;
    static ServerSocket serverSocket = null;
    public static void main(String[] args) {

        try {
            serverSocket = new ServerSocket(8189);
            System.out.println("Сервер запущен");
            socket = serverSocket.accept();
            inputStream = new DataInputStream(socket.getInputStream());
            outputStream = new DataOutputStream(socket.getOutputStream());
            System.out.println("Клиент подключился");
            Server server1 = new Server();

            server1.sendMsg();
            server1.receiveMsg();


        } catch (IOException e) {
            e.printStackTrace();
        }
        }


    public void sendMsg() {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        new Thread(() -> {
            try {
                while (true) {
                    String msg = br.readLine();
                    outputStream.writeUTF(msg);
                    outputStream.flush();
                }
            } catch (IOException e) {
                System.out.println("Ошибка отправки со стороны сервера!");
            }
        }).start();
    }

    public void receiveMsg() {

        new Thread(() -> {
            try {
                while (true) {
                    String str = inputStream.readUTF();
                    System.out.println("client: " + str);
                    if (str.equals("/end")) {
                        System.out.println("Клиент отключился");
                        socket.close();
                        serverSocket.close();
                        break;
                    }
                }
            } catch (IOException e) {
                System.out.println("Ошибка получения со стороны сервера!!");
            }
        }).start();
    }
}

