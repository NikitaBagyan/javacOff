package src.main.SkillFactory.deadLock;

public class Deadlock implements Runnable {

    private static final Object lock1 = new Object();
    private static final Object lock2 = new Object();

    public static void main(String[] args) {
        Deadlock deadlock = new Deadlock();
        new Thread(deadlock).start();
        new Thread(deadlock).start();
    }

    @Override
    public void run() {
        doTask1();
        doTask2();
    }

    private synchronized void doTask1() {
        System.out.println("Doing task 1");

    }


    private synchronized void doTask2() {
        System.out.println("Doing task 2");
    }
}

