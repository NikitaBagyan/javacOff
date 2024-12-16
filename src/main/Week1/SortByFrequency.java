package src.main.Week1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortByFrequency {

    public static void main(String[] args) {
        System.out.println(sortByFrequency("aaabbbbccrtyyuu"));
    }

    public static String sortByFrequency(String input) {

        Map<Character, Integer> frequencyMap = new HashMap<>();

        for (char c : input.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }
        List<Character> frequencyList = new ArrayList<>(frequencyMap.keySet());

        frequencyList.sort((a, b) -> {
            int frequenceCompare = frequencyMap.get(b).compareTo(frequencyMap.get(a));
            if (frequenceCompare == 0) {
                return Character.compare(a, b);
            }
            return frequenceCompare;
        });

        StringBuilder sortedString = new StringBuilder();

        for (char c : frequencyList) {
            int frequency = frequencyMap.get(c);

            for (int i = 0; i < frequency; i++) {
                sortedString.append(c);
            }
        }
        return sortedString.toString();
    }
}



