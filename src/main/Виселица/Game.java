package src.main.Виселица;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

 class Game {

    protected void startGame(String input, String playword) {

        boolean endGame = false;
        Scanner scanner = new Scanner(System.in);
        int lives = 5;
        StringBuilder secretWord = new StringBuilder(playword.replaceAll("[а-я]", "*"));
        List<Character> enteredCharacters = new ArrayList<>();

        System.out.println("Ваше слово " + secretWord);

        System.out.println("Игра начинается");

        while (!endGame) {

            if (secretWord.toString().contains("*")) {
                System.out.println("Введите букву");
                input = scanner.nextLine();

                if (input.isEmpty()) {
                    System.out.println("Вы ничего не ввели, попробуйте еще раз!!!");
                    continue;
                }

                if (input.length() > 1) {
                    System.out.println("Нет, только одну!");
                    continue;
                }

                char inputLetter = input.charAt(0);

                if (!letterValidation(inputLetter)) {
                    System.out.println("Нет, с маленькой буквы и на Русском языке!!!");
                    continue;
                }

                if (enteredCharacters.contains(inputLetter)) {
                    System.out.println("Эту букву вы уже вводили.");
                    continue;
                }


                enteredCharacters.add(inputLetter);

                if (playword.indexOf(inputLetter) != -1) {
                    revealLetter(secretWord, playword, inputLetter);
                    System.out.println("Ваше слово " + secretWord);
                } else {

                    lives = isWrongLetter(lives, inputLetter);

                    if (lives == 0) {
                        livesValidation(lives);
                        System.out.println("Вы погибли");
                        System.out.println("Вашим словом было - " + playword);
                        endGame = true;
                    }


                }


            } else {

                System.out.println("УРАААА, я спасен!!! Вы угадали слово");

                endGame = true;
            }
        }

    }

    private int isWrongLetter(int lives, char inputLetter) {
        lives--;
        System.out.println("Вы не угадали букву: " + inputLetter);
        livesValidation(lives);
        String livesOutput = (lives == 1) ? "жизнь" : "жизни";
        System.out.println("У вас осталось " + lives + " " + livesOutput);
        return lives;
    }


    private void revealLetter(StringBuilder secretWord, String playword, char inputLetter) {
        System.out.println("Вы угадали букву!");
        for (int i = 0; i < playword.length(); i++) {
            if (playword.charAt(i) == inputLetter) {
                secretWord.setCharAt(i, inputLetter);
            }
        }
    }

    private void livesValidation(int lives) {

        switch (lives) {
            case 4:
                System.out.println("/|\\");
                break;
            case 3:
                System.out.println(" |");
                System.out.println("/|\\");
                break;
            case 2:
                System.out.println(" |");
                System.out.println(" |");
                System.out.println("/|\\");
                break;
            case 1:
                System.out.println("  ____");
                System.out.println(" |");
                System.out.println(" |");
                System.out.println("/|\\");
                break;
            case 0:
                System.out.println("  _____");
                System.out.println(" |     *");
                System.out.println(" |    /|\\");
                System.out.println("/|\\   / \\");
                break;
        }


    }

    private boolean letterValidation(char letter) {
        if (Character.isLowerCase(letter) && letter >= 'а' && letter <= 'я') {
            return true;
        } else return false;
    }
}