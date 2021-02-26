package main;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

    public static void main(String[] args) throws IOException {

        System.out.println("Server Started!");
        ServerSocket listener = new ServerSocket(8000);
        System.out.println("Server Waiting for connection!");
        Socket client = listener.accept();
        System.out.println("Connected to client!");
        BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        while(true) {
            String clientNumber = in.readLine();
            System.out.println("Client Data : " + clientNumber);
            String output = clientNumber + "!!!";

            /*Print to client outputStream*/
            PrintWriter printWriter = new PrintWriter(client.getOutputStream(), true);
            printWriter.println("[Server] : Really " + output);
        }

    }
}
