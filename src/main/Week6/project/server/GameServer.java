package src.main.Week6.project.server;

import src.main.Week6.project.client.PlayerClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class GameServer {

    private static final int PORT = 1234;
    private static final int MAX_PLAYERS = 2;

    private static BufferedReader in;
    private static PrintWriter out;

    private final List<ClientHandler> playerClientList = new ArrayList<>();

    private static int playerCounter = 0;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Сервер запущен");
            while (true) {
                try {
                    Socket socket = server.accept();
                    System.out.println("Игрок подключился");
                    out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
                    out.println("Приветствую тебя на сервере игры \"Морской бой\"");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}
