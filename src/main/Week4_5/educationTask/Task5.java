package src.main.Week4_5.educationTask;
/*
Симуляция interrupt(): Напишите поток, который выполняет долгую задачу, и прерывайте его через interrupt().
Почему ничего не вышло?*/

public class Task5 extends Thread {
    public static void main(String[] args) throws InterruptedException {

        Task5 task5 = new Task5();
        task5.start();
        task5.interrupt();
        task5.join();
    }

    @Override
    public void run() {
        int temp = 0;
        System.out.println("Делаю, что то очень долго");
        for (int i = 0; i < 2000000000; i++) {
            temp += i;
        }
        System.out.println("Делаю, что то очень долго");
        for (int i = 0; i < 2000000000; i++) {
            temp += i;
        }
        System.out.println("Делаю, что то очень долго");
        for (int i = 0; i < 2000000000; i++) {
            temp += i;
        }
        System.out.println("Делаю, что то очень долго");
        for (int i = 0; i < 2000000000; i++) {
            temp += i;
        }
        System.out.println("Делаю, что то очень долго");
        for (int i = 0; i < 2000000000; i++) {
            temp += i;
        }
        System.out.println("Делаю, что то очень долго");
        for (int i = 0; i < 2000000000; i++) {
            temp += i;
        }
        System.out.println("Делаю, что то очень долго");
        for (int i = 0; i < 2000000000; i++) {
            temp += i;
        }
        System.out.println("Делаю, что то очень долго");
        for (int i = 0; i < 2000000000; i++) {
            temp += i;
        }
        System.out.println("Делаю, что то очень долго");
        for (int i = 0; i < 2000000000; i++) {
            temp += i;
        }
        System.out.println("Делаю, что то очень долго");
        for (int i = 0; i < 2000000000; i++) {
            temp += i;
        }
        System.out.println("Делаю, что то очень долго");
        for (int i = 0; i < 2000000000; i++) {
            temp += i;
        }
        System.out.println("Делаю, что то очень долго");
        for (int i = 0; i < 2000000000; i++) {
            temp += i;
        }
        System.out.println("Делаю, что то очень долго");
        for (int i = 0; i < 2000000000; i++) {
            temp += i;
        }
        System.out.println("Делаю, что то очень долго");
        for (int i = 0; i < 2000000000; i++) {
            temp += i;
        }
        System.out.println("Делаю, что то очень долго");
    }
}
