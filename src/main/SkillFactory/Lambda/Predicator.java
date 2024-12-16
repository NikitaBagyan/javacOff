package src.main.SkillFactory.Lambda;

/*Создайте список чисел и используйте Predicate для фильтрации четных чисел. Верните новый список, содержащий только четные числа.*/

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Predicator {

    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            integerList.add(i);
        }
        Predicate<Integer> predicate = value -> value % 2 == 0;
        List<Integer> resultList = integerList.stream()
                .filter(predicate)
                .collect(Collectors.toList());
        System.out.println(resultList);
    }
}

