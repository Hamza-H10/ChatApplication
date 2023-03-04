package com.Projects.ChatApplication;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Console_Client {
// make exit thread - by inter thread communication

    //[Constructor] - here initialising Socket , BufferReader , PrintWriter
    public class Client extends JFrame {
        Socket socket;
        BufferedReader br;// br is used for reading
        PrintWriter out;

        //FOR GUI - DECLARING COMPONENTS
        private JLabel heading = new JLabel("Client Area");
        private JTextArea messageArea = new JTextArea();
        private JTextField messageInput = new JTextField();
        private Font font = new Font("Roboto",Font.PLAIN,20);


        public Client(){
            try {
            System.out.println("Sending request to server");
            socket = new Socket("127.0.0.1", 7777);
            System.out.println("connection done.");

            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream());

// //               calling method to create gui
            startReading();
            startWriting();

            }catch (Exception e) {
                e.printStackTrace();
            }
        }





        //Start Reading [Method]
        public void startReading() {
            //thread-read karke deta rehega
            Runnable r1 = () -> {
                System.out.println("reader started...");
                try {
                    while (true) {
//                System.out.println("Now entered the while loop");
                        String msg = br.readLine();
                        if (msg.equals("quit")) {
                            System.out.println("Server terminated the chat");
                            socket.close();
                            break;
                        }
                        System.out.println("Server : " + msg);
                    }
                }catch (Exception e) {
//                e.printStackTrace();
                    System.out.println("connection is closed");
                }
            };
            new Thread(r1).start();//starting the thread r1
        }

        // start writing [Method]
        public void startWriting() {
            //thread - data user ka lega and then send karega client tak
            Runnable r2 = () -> {
                System.out.println("writer started...");
                try {
                    while (!socket.isClosed()) {
//                        System.out.println("In client writing Thread's while loop ");
                        BufferedReader br1 = new BufferedReader(new
                                InputStreamReader(System.in));//InputStreamReader
                        String content = br1.readLine();
                        out.println(content);
                        out.flush();//for sometimes when data is not going.

                        if(content.equals("exit"))
                        {
                            System.out.println("client writer has exited");
                            socket.close();
                            break;
                        }
                    }
                } catch (Exception e) {
//                        e.printStackTrace();
                    System.out.println("Connection closed");
                }
            };
            new Thread(r2).start();
        }

        public static void main(String[] args) {
            System.out.println("This is client");
            new com.Projects.ChatApplication.Client();
        }
    }

}
