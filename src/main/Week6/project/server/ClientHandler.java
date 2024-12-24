package src.main.Week6.project.server;

import java.io.*;
import java.net.Socket;

public class ClientHandler {

    Socket socket;
    BufferedReader in;
    PrintWriter out;
    String playerName;

    public ClientHandler(String playerName, Socket socket) throws IOException {
        this.playerName = playerName;
        this.socket = socket;
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()),true);
    }


}
