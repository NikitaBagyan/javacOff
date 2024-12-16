package src.main.SkillFactory.Lambda;

/*Используйте Stream API для сортировки списка строк по длине строки. Используйте лямбда-выражение для определения порядка сортировки.*/

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LambdaCompare {

    public static void main(String[] args) {
        List<String>stringList = new ArrayList<>();
        stringList.add("a");
        stringList.add("ello");
        stringList.add("bHllbiio");
        stringList.add("Hefdfgdo");


    List<String>stringList1 =  stringList.stream()
                .sorted(Comparator.comparingInt(String::length))
                .toList();
        System.out.println(stringList1);

    }
}
