package src.main.Week4_5.educationTask;

/*Использование wait() и notify(): Реализуйте простую программу, использующую wait() и notify() для
синхронизации выполнения двух потоков.*/

class SharedResource {
    private boolean ready = false;

    public synchronized void waitForReady() throws InterruptedException {
        while (!ready) {
            System.out.println("Засыпаем и ждем");
            wait();  // Ждём, пока готовность не станет true
        }
        System.out.println("Просыпаемся! Ресурс готов!");
    }

    public synchronized void setReady() {
        ready = true;
        notify();  // Уведомляем один поток, который ждёт
    }
}

public class Task4 {
    public static void main(String[] args) throws InterruptedException {
        SharedResource sharedResource = new SharedResource();

        // Поток, который ожидает, пока ресурс не станет готов
        Thread waitingThread = new Thread(() -> {
            try {
                sharedResource.waitForReady();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        waitingThread.start();

        // Поток, который делает ресурс готовым
        Thread readyThread = new Thread(() -> {
            try {
                Thread.sleep(2000);  // Задержка перед установкой готовности
                sharedResource.setReady();
                System.out.println("Ресурс теперь готов");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        readyThread.start();

        waitingThread.join();
        readyThread.join();
    }
}
