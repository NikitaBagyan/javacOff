package src.main.Week1;

public class ProcessingString {

    public static void main(String[] args) {

        String input = "Money Long";
        String result = "";
        char[] characters = input.toCharArray();
        char[] resultCharacter = new char[characters.length];

        for (int i = characters.length - 1, j = 0; i >= 0; i--, j++) {
            resultCharacter[j] = characters[i];
        }

        result = String.valueOf(resultCharacter);

        System.out.println(result);
    }
}
