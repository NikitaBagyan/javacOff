package src.main.Week6.Homework;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.net.Socket;

public class ServerSomthing extends Thread {

    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;
    private String clientName;

    public ServerSomthing(Socket socket, String clientName) throws IOException {
        this.socket = socket;
        this.clientName = clientName;
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
        start();
    }

    @Override
    public void run() {
        String word;
        try {
            while (true) {
                word = in.readLine();
                System.out.println("Клиент прислал сообщение: " + word);
                if (!validateClientMessageAndGetCatFact(word)) {
                    break;
                }
                for (ServerSomthing somthing : Server.clientList)
                    somthing.sendMessage(clientName + ": " + word);
            }
        } catch (IOException e) {
            System.err.println(e);
        }
    }

    private void sendMessage(String word) {
        out.println(word);
    }

    private boolean validateClientMessageAndGetCatFact(String message) {
        if (message.equals("stop")) {
            out.println("Вы вышли из чата");
            return false;
        } else if (message.equals("/catfact")) {
            out.println("Ваш котоФакт:");
            CatFact catFact = WebApiCatFacts.getFact();
            sendMessage(catFact.getFact());

            // Сохраняем объект в двоичном формате (Java-сериализация)
            saveCatFactAsBinary(catFact, "catfacts.dat");

            // Сохраняем объект в JSON формате
            saveCatFactAsJson(catFact, "catfacts.json");
        }
        return true;
    }

    private void saveCatFactAsBinary(CatFact catFact, String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName, true))) {
            oos.writeObject(catFact);
        } catch (IOException e) {
            System.err.println("Ошибка при сохранении котофакта в бинарном формате: " + e.getMessage());
        }
    }

    private void saveCatFactAsJson(CatFact catFact, String fileName) {
        try (FileWriter fw = new FileWriter(fileName, true)) {
            ObjectMapper mapper = new ObjectMapper();
            // Запишем каждый объект на новой строке, чтобы не ломать структуру файла.
            fw.write(mapper.writeValueAsString(catFact));
            fw.write("\n");
        } catch (IOException e) {
            System.err.println("Ошибка при сохранении котофакта в JSON: " + e.getMessage());
        }
    }
}
