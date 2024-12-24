package src.main.Week6.project.client;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class PlayerClient {

    private final int PORT = 1234;

    public static void main(String[] args) {
        PlayerClient playerClient = new PlayerClient();
        playerClient.playerStartGame();
    }

    public void playerStartGame() {
        try (Socket socket = new Socket("localHost", PORT);
             Scanner scanner = new Scanner(System.in);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true)) {

            System.out.println("Привет я друг, испугался не бойся");

            String serverRequest = in.readLine();
            System.out.println(serverRequest);

            System.out.println("Нажми enter для авторизации на сервере или напиши exitGame для выхода");
            String playerInput = scanner.nextLine();

            if (ValidatorExitGame.validateExitGame(playerInput)) {
                System.out.println("Отключаемся от сервера");
                throw new GameOverException("Соединение прервано");
            }

            if (AuthorizationClient.authorization()) {
                out.println();
            }

            new ReadMessage(in).start();
            new WriteMessage(out, scanner).start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private class ReadMessage extends Thread {
        BufferedReader in;

        public ReadMessage(BufferedReader in) {
            this.in = in;
        }

        @Override
        public void run() {
            String inputString;
            try {
                while (true) {
                    if ((inputString = in.readLine()) != null) {
                        if (ValidatorExitGame.validateExitGame(inputString)) {
                            System.out.println("Сервер остановил соединение. Выход...");
                            break;
                        }
                        System.out.println(in);
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private class WriteMessage extends Thread {
        Scanner scanner;
        PrintWriter out;

        public WriteMessage(PrintWriter out, Scanner scanner) {
            this.out = out;
            this.scanner = scanner;
        }

        @Override
        public void run() {
            try {
                while (true) {
                    String userWord = scanner.nextLine();
                    out.println(userWord);
                    if (ValidatorExitGame.validateExitGame(userWord)) {
                        break;
                    }
                }
            } catch (Exception e) {
                System.err.println("Ошибка при отправке сообщения на сервер: " + e);
            }
        }
    }
}