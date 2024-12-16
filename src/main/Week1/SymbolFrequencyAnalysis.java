package src.main.Week1;


import java.util.HashMap;
import java.util.Map;

public class SymbolFrequencyAnalysis {

    public static void main(String[] args) {

        String input = "Panamaman";

        Map<Character, Integer> result = new HashMap<>();

        for (char ch : input.toCharArray()) {

            if(result.containsKey(ch)){
                result.put(ch, result.get(ch) + 1);
            }else {
                result.put(ch,1);
            }
        }
        for (Map.Entry<Character, Integer> entry : result.entrySet()){
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }
    }
}
