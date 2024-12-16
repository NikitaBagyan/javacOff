package src.main.SkillFactory;

//Напишите метод, который будет принимать 2 объекта:
// 1 типа LocalTime и 2 типа Duration, и будет возвращать true, если переданное время + промежуток больше текущего времени.

import java.time.Duration;
import java.time.LocalTime;

public class PeriodDuration {

    boolean add(LocalTime localTime, Duration duration) {
        if ((localTime.plus(duration)).isAfter(LocalTime.now())) {
            return true;
        } else return false;
    }
}
