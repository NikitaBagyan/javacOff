package src.main.Week1;

//Арифметическая прогрессия Реализуйте метод, который принимает в качестве аргументов первый элемент, шаг и количество элементов арифметической прогрессии, и возвращает массив содержащий прогрессию.


import java.util.Arrays;

public class ArithmeticProgression {

    static int[] calculateArithmeticProgression (int firstNumber,int step, int quantitty) {
        int[]result = new int[quantitty];
        for (int i = 0, j = firstNumber; i < quantitty; i++, j += step) {
            result[i] = j;
        }
        return result;
    }

    public static void main(String[] args) {

        System.out.println(Arrays.toString(calculateArithmeticProgression(3,2,10)));

    }


}
