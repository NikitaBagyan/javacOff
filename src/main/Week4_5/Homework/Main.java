package src.main.Week4_5.Homework;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Шаблон карты: 0 - пустая ячейка, 1 - стена, A/B - колонии
        String[][] template = {
                {"A", "0", "0", "1", "B"},
                {"0", "0", "0", "1", "0"},
                {"0", "A", "1", "0", "0"},
                {"1", "0", "B", "0", "1"},
                {"B", "1", "0", "0", "A"}
        };

        // Создание колоний
        Colony colonyA = new Colony("A", 5000); // Колония A
        Colony colonyB = new Colony("B", 5000); // Колония B
        List<Colony> colonies = Arrays.asList(colonyA, colonyB);

        // Создание карты
        Map map = new Map(template, colonies);

        // Запуск игры
        Game game = new Game(map, colonies);

        System.out.println("=== Начало симуляции ===");
        game.start(10); // Запускаем игру на 10 шагов
        System.out.println("=== Конец симуляции ===");
    }
}
