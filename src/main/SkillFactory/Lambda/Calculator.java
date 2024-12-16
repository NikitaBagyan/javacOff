package src.main.SkillFactory.Lambda;
/*
Создайте класс Calculator с методом calculate, который принимает два числа и BiFunction<Integer, Integer, Integer>.
Используйте лямбда-выражение для выполнения различных математических операций (например, сложение, вычитание).
*/

import java.util.function.BiFunction;

public class Calculator {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Integer result = calculator.calculate(10,15, (a,b) -> a * b);
        System.out.println(result);
    }

    Integer calculate(Integer a, Integer b, BiFunction<Integer, Integer, Integer> biFunction){
        return biFunction.apply(a,b);
    }
}


