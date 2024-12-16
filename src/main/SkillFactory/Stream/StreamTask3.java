package src.main.SkillFactory.Stream;

/*
Решите задачу при помощи стримов:

Сгенерируйте последовательность чисел от 1 до 100 включительно, ограничьте ее последними 50 числами,
оставьте только те числа, которые делятся без остатка на 2 или на 5,
и посчитайте сумму полученных чисел. В ответе у вас должно выйти 2275.
*/

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTask3 {
    public static void main(String[] args) {

        int result = IntStream.rangeClosed(1, 100)
                .skip(50)
                .filter(a -> a % 2 == 0 || a % 5 == 0)
                .sum();
        System.out.println(result);
    }
}