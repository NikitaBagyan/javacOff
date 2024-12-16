package src.main.Week4_5.educationTask;

/*
Изучение состояний потока: Разработайте приложение, которое выводит текущее состояние потока (NEW, RUNNABLE, BLOCKED, WAITING, TERMINATED).
*/

public class Task6 {

    private boolean waitFlag = false;

    // Метод для ожидания
    synchronized void waitingFor() throws InterruptedException {
        while (!waitFlag) {
            System.out.println(Thread.currentThread().getName() + " в ожидании: " + Thread.currentThread().getState());
            wait();
        }
        System.out.println(Thread.currentThread().getName() + " проснулся: " + Thread.currentThread().getState());
    }

    // Метод для установки флага готовности
    synchronized void setReady() throws InterruptedException {
        waitFlag = true;
        System.out.println(Thread.currentThread().getName() + " в setReady: " + Thread.currentThread().getState());
        notify();
    }

    public static void main(String[] args) throws InterruptedException {
        Task6 task6 = new Task6();

        // Поток, который выполняет долгую задачу и затем ожидает
        Thread thread = new Thread(() -> {
            int temp = 0;
            System.out.println(Thread.currentThread().getName() + " начальное состояние: " + Thread.currentThread().getState());
            System.out.println(Thread.currentThread().getName() + " начинает долгую работу");
            for (int i = 0; i < 2000000090; i++) {
                temp += i;
            }
            try {
                task6.waitingFor();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // Поток, который позже установит флаг готовности
        Thread readyThread = new Thread(() -> {
            try {
                Thread.sleep(2000);  // Задержка перед установкой готовности
                task6.setReady();
                System.out.println(Thread.currentThread().getName() + " установил ресурс как готовый");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // Вывод начального состояния потоков
        System.out.println(thread.getName() + " начальное состояние: " + thread.getState());
        System.out.println(readyThread.getName() + " начальное состояние: " + readyThread.getState());

        // Запуск потоков
        thread.start();
        readyThread.start();

        // Вывод текущего состояния потоков после старта
        Thread.sleep(500); // Задержка для начала выполнения потоков
        System.out.println(thread.getName() + " после старта: " + thread.getState());
        System.out.println(readyThread.getName() + " после старта: " + readyThread.getState());

        // Ожидание завершения потоков
        thread.join();
        readyThread.join();

        // Вывод состояния потоков после их завершения
        System.out.println(thread.getName() + " завершен: " + thread.getState());
        System.out.println(readyThread.getName() + " завершен: " + readyThread.getState());
    }
}
