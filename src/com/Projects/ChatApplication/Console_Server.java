package com.Projects.ChatApplication;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Console_Server {
    public class Server {
        ServerSocket server;
        Socket socket;
        BufferedReader br;// br is used for reading
        PrintWriter out;// out is used for writing

        //constructor
        public Server() {

            try {
                server = new ServerSocket(7777);
                System.out.println("Server is ready to accept connection");
                socket = server.accept();

                br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream());
                startReading();
                startWriting();

            } catch (Exception e) {
                //todo: handle the exception
                e.printStackTrace();
            }
        }

        public void startReading() {
            //thread-read karke deta rehega
            Runnable r1 = () -> {
                System.out.println("reader started...");
                try {
                    while (true) {
//                System.out.println("Now entered the while loop");
                        String msg = br.readLine();
                        if (msg.equals("quit")) {
                            System.out.println("Client terminated the chat");
                            socket.close();
                            break;
                        }
                        System.out.println("Client : " + msg);
                    }
                } catch (Exception e) {
//                e.printStackTrace();
                    System.out.println("connection is closed");
                }
            };
            new Thread(r1).start();//starting the thread r1
        }

        public void startWriting() {
            //thread - data user lega and then send karega client tak
            Runnable r2 = () -> {
                System.out.println("writer started...");
                try {
                    //we have to write until the socket is not closed
                    while (!socket.isClosed()) {
//                        System.out.println("In Server writing Thread's while loop ");
                        BufferedReader br1 = new BufferedReader(new
                                InputStreamReader(System.in));//InputStreamReader
                        String content = br1.readLine();

                        out.println(content);
                        out.flush();//for sometimes when data is not going.

                        if (content.equals("exit")) {
                            System.out.println("Server writer has exited");
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

        public void main(String[] args) {
            System.out.println("This is server...starting the server");
            //instantiation of constructor
            new Server();
        }
    }
}








