package src.main.Week1;

public class Palindroms {

    public static void main(String[] args) {

        boolean isPalindrom = false;
        String input = "A man a plan a canal Panama".replaceAll("\\s","").toLowerCase();
        StringBuilder reverseBuilder = new StringBuilder(input);
        String reverse = reverseBuilder.reverse().toString();
        isPalindrom = reverse.contentEquals(input) ? true : false;

        System.out.println(isPalindrom);
    }
}
