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
            inputStream = new DataInputStream(c.getInputStream());
            outputStream = new DataOutputStream(c.getOutputStream());

            client.receiveMsg();
            client.sendMsg();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMsg() throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        new Thread(() -> {
            try {
                while (true) {
                    String msg = br.readLine();
                    if (msg.isEmpty()) receiveMsg();
                    outputStream.writeUTF(msg);
                    outputStream.flush();
                }
            } catch (IOException e) {

            }
        }).start();
    }

    public void receiveMsg() {

        new Thread(() -> {
            try {
                System.out.println(inputStream.readUTF());
            } catch (IOException e) {

            }
        }).start();
    }
}
