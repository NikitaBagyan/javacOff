package src.main.Week6.project.client;

import java.io.IOException;
import java.util.Scanner;

public class AuthorizationClient {

    private static final int allAttempts = 5;
    private static final Scanner scanner = new Scanner(System.in);

    public static boolean authorization() {
        int playersAttempts = 0;
        String playersInput = "";

        System.out.println("Введите ваше имя английскими буквами, не используйте цифры и специальные знаки");

        while (playersAttempts <= allAttempts) {
            playersInput = scanner.nextLine();
            if (!valiidateWord(playersInput)) {
                playersAttempts++;
                continue;
            }
            return true;
        }
        return false;
    }

    private static boolean valiidateWord(String name) {
        char[] wordArr = name.toCharArray();
        for (char ch : wordArr) {
            if (!Character.isLowerCase(ch)) {
                System.out.println("Вы ввели недоспустимый формат имени");
                return false;
            }
        }
        return true;
    }
}
