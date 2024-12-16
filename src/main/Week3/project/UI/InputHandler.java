package src.main.Week3.project.UI;

import java.util.Scanner;

public class InputHandler {
    private final Scanner scanner = new Scanner(System.in);

    public int getIntInput(String prompt) {
        System.out.println(prompt);
        while (!scanner.hasNextInt()) {
            System.out.println("Пожалуйста, введите целое число:");
            scanner.next();
        }
        int result = scanner.nextInt();
        scanner.nextLine(); // Очистка строки
        return result;
    }

    public String getStringInput(String prompt) {
        System.out.println(prompt);
        return scanner.nextLine();
    }

    public void print(String message) {
        System.out.println(message);
    }
}

