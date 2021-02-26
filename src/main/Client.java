package main;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) throws IOException {

        Socket server = new Socket("127.0.0.1", 8000);
        InputStream serverInputStream = server.getInputStream();
        OutputStream serverOutputStream = server.getOutputStream();

        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader serverIn = new BufferedReader(new InputStreamReader(serverInputStream));
        PrintWriter printWriter = new PrintWriter(serverOutputStream, true);
        while(true) {
            System.out.println("[Client] : ");
            String name = keyboard.readLine();
            printWriter.println(name);

            String serverOutPut = serverIn.readLine();
            System.out.println(serverOutPut);
        }

    }
}
