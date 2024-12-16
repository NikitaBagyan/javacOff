package src.main.Виселица;

import java.util.Scanner;

 class Hangman {

    protected void play() {

        Game game = new Game();
        Scanner scanner = new Scanner(System.in);
        boolean endGame = false;

        System.out.println("Хотите начать игру? Да(ENTER)/Нет(EXIT)");

        String input = scanner.nextLine();

        while (!input.equals("EXIT")) {

            String playWord = Dictionary.randomWord().toLowerCase();
            game.startGame(input, playWord);

            System.out.println("Хотите сыграть снова? Да(Напиши ENTER)/Нет(Напиши (EXIT)");
            input = scanner.nextLine();
        }
    }
}
