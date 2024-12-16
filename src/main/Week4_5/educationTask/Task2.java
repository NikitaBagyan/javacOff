package src.main.Week4_5.educationTask;
/*
Сравните run() и start(): Создайте и запустите поток, вызвав run() напрямую и через start(), и отметьте
разницу.*/

import java.time.Duration;
import java.time.Instant;

public class Task2 extends Thread {
    static int result = 1;
    public static void main(String[] args) {
        Instant startTime = Instant.now();
        Task2 task2 = new Task2();
        task2.start();
        for (int i = 0; i < 2000000000; i++) {
            result*= i;
        }
        //время выполнения с методом run около 4300 если запустить с методом start() около 1500 милисекунд;
        Instant endTime = Instant.now();
        Duration timeElapsed = Duration.between(startTime,endTime);
        System.out.println(timeElapsed.toMillis());

    }


    @Override
    public void run() {
        for (int i = 0; i < 2000000000; i++) {
            result+= i;
        }
        for (int i = 0; i < 2000000000; i++) {
            result*= i;
        }
        for (int i = 0; i < 2000000000; i++) {
            result*= i;
        }
    }

}
