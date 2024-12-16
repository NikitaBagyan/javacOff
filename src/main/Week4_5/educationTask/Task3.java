package src.main.Week4_5.educationTask;
/*Инициализация и приоритет потоков: Создайте два потока с различными приоритетами и выведите их в работу.
Демон-поток: Создайте поток, выполните его как демон и покажите, что происходит с его завершением при завершении
основного потока.*/

import java.time.Duration;
import java.time.Instant;

public class Task3 {

    public static void main(String[] args) {

        Thread thread1 = new Thread(() -> {
            int temp = 1;
            int result = 0;
            while (true) {
                Instant start = Instant.now();
                for (int i = 1; i < 2000000000; i++) {
                    result = temp / i;
                }
                try {
                    Thread.sleep(1200);
                } catch (InterruptedException e) {
                    Instant end = Instant.now();
                    Duration resultTime = Duration.between(start, end);
                    System.out.println("Поток 1 завершился за " + resultTime.toMillis() + " секунд");
                    break;
                }
            }
        });
        Thread thread2 = new Thread(() -> {
            int temp = 1;
            int result = 0;
            while (true) {
                Instant start = Instant.now();
                for (int i = 1; i < 2000000000; i++) {
                    result = temp / i;
                }
                try {
                    Thread.sleep(1200);
                } catch (InterruptedException e) {
                    Instant end = Instant.now();
                    Duration resultTime = Duration.between(start, end);
                    System.out.println("Поток 2 завершился за " + resultTime.toMillis() + " секунд");
                    break;
                }
            }
        });
        Thread threadDaemon = new Thread(() -> {
            int temp = 1;
            int result = 0;
                Instant start = Instant.now();
                for (int i = 1; i < 2000000000; i++) {
                    result = temp / i;
                }
                    Instant end = Instant.now();
                    Duration resultTime = Duration.between(start, end);
                    System.out.println(result);
                    System.out.println("Поток демон завершился за " + resultTime.toMillis() + " секунд");
        });
        thread1.setPriority(10);
        threadDaemon.setDaemon(true);
        thread1.start();
        thread2.start();
        threadDaemon.start();
        try {
            Thread.sleep(5000);
            thread1.interrupt();
            thread2.interrupt();
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Основной поток завершен");
    }
}