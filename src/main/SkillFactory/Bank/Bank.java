package src.main.SkillFactory.Bank;

import java.util.concurrent.atomic.AtomicInteger;

public class Bank {

    private AtomicInteger money = new AtomicInteger(10000);

    int getMoney() {
        return money.get();
    }

    void take(int amount) {
            money.addAndGet(-amount);
    }

    void repay(int amount) {

        money.addAndGet(amount);
    }

    class Client extends Thread {
        @Override
        public void run() {
            while (true) {
                // выдаем кредит, только если
                // есть свободные средства
                if (getMoney() >= 1000) {
                    take(1000);
                    repay(1000);
                }
            }
        }
    }

    // Конструктор должен находиться внутри класса Bank
    public Bank() {
        for (int i = 0; i < 7; i++) {
            new Client().start();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Bank bank = new Bank();
        while (true) {
            System.out.println(bank.money);
            Thread.sleep(1000);
        }
    }
}
