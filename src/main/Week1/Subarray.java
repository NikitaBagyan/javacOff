package src.main.Week1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Subarray {

    public static void main(String[] args) {

        Integer[] inputArray = new Integer[]{10, 12, 11, 14};
        int counterSubarray = 1;
        List<Integer> sortedList = Arrays.asList(inputArray);
        List<Integer> resultList = new ArrayList<>();
        Collections.sort(sortedList);
        resultList.add(sortedList.get(0));

        for (int i = 1; i < sortedList.size(); i++) {
            if(sortedList.get(i) == sortedList.get(i - 1) + 1){
                counterSubarray++;
                resultList.add(sortedList.get(i));
            }
        }

        for (int i : resultList) {
            System.out.println(i);
        }
        System.out.println("Длинна массива " + counterSubarray);
    }
}
