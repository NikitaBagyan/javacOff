package src.main.Week4_5.educationTask;

/*Простые задачи:
Основные концепции многопоточности:
Создайте поток с использованием класса Thread: Напишите класс, который наследует Thread и выводит сообщение
при запуске.
Создайте поток с использованием интерфейса Runnable: Напишите класс, реализующий Runnable, и запустите его в
потоке.*/

public class Task1 extends Thread {
    public static void main(String[] args) {

        Thread myThread = new Thread(() -> {
            while (true) {
                System.out.println("Поспим");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    break;
                }
            }
        });

        myThread.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Основной поток спит");
        myThread.interrupt();
        RunnableTask runnableTask = new RunnableTask();
        runnableTask.thread.start();
    }
}
class RunnableTask {

    Runnable task = () -> {
        for (int i = 0; i < 10; i++) {
            System.out.println("делаем задачу номер " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    };

    Thread thread = new Thread(task);


}