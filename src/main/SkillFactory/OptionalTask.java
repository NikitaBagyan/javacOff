package src.main.SkillFactory;

import java.util.Optional;
import java.util.function.Supplier;

/*
Напишите такой метод, который принимает 1 параметр типа int guess (догадка) в диапазоне от 1 до 5 и возвращает Optional<String> (выигрыш).
Внутри метода реализуйте следующую логику:

если передаваемый guess не в требуемом диапазоне — бросайте IllegalStateException;
иначе: генерируйте рандомное значение int (для этого вам понадобится метод nextInt(int bound) класса java.util.Random);
если сгенерированное значение равняется переданному значению guess, тогда возвращайте Optional.of(“Поздравляем! Вы угадали значение!”));
если же нет — Optional.empty().
Протестируйте ваш метод из main(), обрабатывая Optional<String> как вы хотите.
*/

public class OptionalTask {

    public static void main(String[] args) {
        OptionalTask optionalTask = new OptionalTask();
        Optional<String> optional = optionalTask.getWinner(3);
        System.out.println(optional.orElseThrow(() -> new IllegalArgumentException()));
    }

    public Optional<String> getWinner(int guess) {
        if (guess < 1 || guess > 5) {
            throw new IllegalArgumentException();
        } else {
            Supplier<Integer> randomIntSupplier = () -> 1 + (int) (Math.random() * 5);
            int randInt = randomIntSupplier.get();
            if (guess == randInt) {
                return Optional.of("Поздравляем! Вы угадали значение!");
            } else {
                System.out.println("Увы");
                return Optional.empty();
            }
        }
    }
}