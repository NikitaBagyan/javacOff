package src.main.Week6.Homework;

import java.io.*;
import java.net.Socket;

public class Authorization {

    private final int AUTHORIZATION_ATTEMPS = 5;
    private final Socket socket;
    private final BufferedReader in;
    private final PrintWriter out;

    private int chechikCounter = 0; //счетчик чечиков

    public Authorization(Socket socket) throws IOException {
        this.socket = socket;
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
    }

    private static final int AUTHORIZATION_ATTEMPTS = 3;

    public String authorizate() throws IOException {
        String clientName = requestAndValidateName();
        if (clientName == null) {
            clientName = "чечик"; // дефолтное имя, если все попытки исчерпаны
            out.println("Вы не прошли авторизацию, вам присвоено имя " + clientName);
            chechikCounter++;
        } else {
            out.println("Вы успешно авторизованы на сервере с именем " + clientName);
        }
        return clientName;
    }

    private String requestAndValidateName() throws IOException {
        int attemptsLeft = AUTHORIZATION_ATTEMPTS;

        while (attemptsLeft > 0) {
            out.println("Введите свое имя:");
            String name = in.readLine();

            if (isNameValid(name)) {
                return name;
            } else {
                attemptsLeft--;
                if (attemptsLeft > 0) {
                    out.println("Неверное имя. Попыток осталось: " + attemptsLeft);
                }
            }
        }

        // Если сюда дошли - попытки закончились
        return null;
    }

    private boolean isNameValid(String name) {
        return name != null && !name.trim().isEmpty();
    }
}
