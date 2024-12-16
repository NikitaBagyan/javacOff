package src.main.SkillFactory;

public class App {

    private int count = 0;

    void increment() { // синхронизируем доступ к операции
        count++;
    }

    public static void main(String[] args) throws InterruptedException {
        App app = new App(); // строка 1
        app.doWork();
    }

    private void doWork() throws InterruptedException {
        Thread t1 = new Thread() {
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    increment();
                }
            }
        };

        Thread t2 = new Thread() {
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    increment();
                }
            }
        };

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Count is: " + count); // Count is: 20000
    }
}