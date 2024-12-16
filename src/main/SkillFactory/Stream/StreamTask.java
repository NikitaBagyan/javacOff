package src.main.SkillFactory.Stream;

import java.util.Arrays;
import java.util.List;

/*
Необходимо список строк перевести в список чисел и произвести их умножение
Решите задачу, сначала используя обычный подход, а затем попробуйте написать тот же код на стримах.
*/
public class StreamTask {

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("1", "2", "3", "4", "5");
        int result = 1;
        for (String str : strings) {
            result *= Integer.parseInt(str);
        }
        System.out.println(result);


        List<String> streamStrings = Arrays.asList("1", "2", "3", "4", "5");
        int streamResult = streamStrings
                .stream()
                .map(Integer::parseInt)
                .reduce(1,(a,b) -> a * b);

        System.out.println(streamResult);

    }
}
