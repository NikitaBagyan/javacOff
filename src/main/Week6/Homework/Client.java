package src.main.Week6.Homework;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    private static final int PORT = 1234;
    private static final String HOST = "localhost";

    public static void main(String[] args) {
        new Client().startClient();
    }

    private void startClient() {
        try (Socket clientSocket = new Socket(HOST, PORT);
             Scanner scanner = new Scanner(System.in);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             PrintWriter out = new PrintWriter(new OutputStreamWriter(clientSocket.getOutputStream()), true)) {

            System.out.println("Успешно подключились к серверу");

            String serverRequest = in.readLine();
            System.out.println(serverRequest);

            String name = scanner.nextLine();
            out.println(name);

            ReadMsg readMsg = new ReadMsg(in);
            WriteMsg writeMsg = new WriteMsg(scanner, out);

            readMsg.start();
            writeMsg.start();

            readMsg.join();
            writeMsg.join();

            System.out.println("Клиент был закрыт");

        } catch (IOException e) {
            System.err.println("Ошибка при работе с сервером: " + e);
        } catch (InterruptedException e) {
            System.err.println("Поток был прерван: " + e);
        }
    }

    private static class ReadMsg extends Thread {
        private final BufferedReader in;

        public ReadMsg(BufferedReader in) {
            this.in = in;
        }

        @Override
        public void run() {
            try {
                String str;
                while ((str = in.readLine()) != null) {
                    if ("stop".equals(str)) {
                        System.out.println("Сервер остановил соединение. Выход...");
                        break;
                    }
                    System.out.println(str);
                }
            } catch (IOException e) {
                System.err.println("Ошибка при чтении сообщения от сервера: " + e);
            }
        }
    }

    private static class WriteMsg extends Thread {
        private final Scanner scanner;
        private final PrintWriter out;

        public WriteMsg(Scanner scanner, PrintWriter out) {
            this.scanner = scanner;
            this.out = out;
        }

        @Override
        public void run() {
            try {
                while (true) {
                    String userWord = scanner.nextLine();
                    out.println(userWord);
                    if ("stop".equalsIgnoreCase(userWord)) {
                        break;
                    }
                }
            } catch (Exception e) {
                System.err.println("Ошибка при отправке сообщения на сервер: " + e);
            }
        }
    }
}
