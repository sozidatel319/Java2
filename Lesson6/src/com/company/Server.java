package com.company;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    static DataInputStream inputStream;
    static DataOutputStream outputStream;
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;

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

        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                System.out.println("Нет клиента, до свидания!");
                socket.close();
                serverSocket.close();
            } catch (IOException e) {
                System.out.println("Закрылся неудачно! Недовольный сервер");
                e.printStackTrace();
            }
        }
    }

    public void sendMsg(){


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
                    System.out.println("server: " + str);
                }
            } catch (IOException e) {
                System.out.println("Ошибка получения со стороны сервера!!");
            }
        }).start();
    }
}

