package src.main.Week1;

import java.util.Arrays;

//Напишите метод, который принимает в качестве параметра массив целых чисел и возвращает новый массив, элементы которого следуют в обратном порядке.
public class InversionArray {

    public static void main(String[] args) {

        System.out.println(Arrays.toString(reverseArray(new int[]{1,2,3,4,5,6,76,8,9,0,0,7,6})));
    }

  static int[] reverseArray(int[] input){

      int [] result = new int[input.length];
      for (int i = input.length - 1, j = 0; i >= 0; i--, j++) {
          result[j] = input[i];
      }
      return result;
    }
}
