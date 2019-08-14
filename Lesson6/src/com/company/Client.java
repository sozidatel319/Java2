package com.company;

import java.io.*;
import java.net.Socket;


public class Client {
    static Socket c;
    static DataInputStream inputStream;
    static DataOutputStream outputStream;
    final static int PORT = 8189;
    final static String IP_ADRESS = "localhost";

    public static void main(String[] args) {

        try {
            Client client = new Client();
            c = new Socket(IP_ADRESS, PORT);
            System.out.println("Подключился к серверу успешно!");
            inputStream = new DataInputStream(c.getInputStream());
            outputStream = new DataOutputStream(c.getOutputStream());

            client.receiveMsg();
            client.sendMsg();

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                System.out.println("Нет сервера, до свидания!");
                c.close();
            } catch (IOException e) {
                System.out.println("Закрылся неудачно! Недовольный клиент!");
                e.printStackTrace();
            }
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
                System.out.println("Ошибка отправки со стороны клиента!");
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
                System.out.println("Ошибка получения со стороны клиента!");
            }
        }).start();
    }
}
