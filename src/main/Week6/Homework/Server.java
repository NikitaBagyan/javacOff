package src.main.Week6.Homework;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {

    private static final int PORT = 1234;

    public static List<ServerSomthing> clientList = new ArrayList<>();
    private static BufferedReader in;
    private static PrintWriter out;


    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            while (true) {
                try {
                    Socket socket = server.accept();
                    Authorization authorization = new Authorization(socket);
                    clientList.add(new ServerSomthing(socket, authorization.authorizate()));
                    out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
                    out.println("Добро пожаловать на котосервер, введите /catfact для поднятия настроения");
                } catch (IOException e) {
                    server.close();
                }
            }
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}


