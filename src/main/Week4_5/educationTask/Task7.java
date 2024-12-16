package src.main.Week4_5.educationTask;

/*Реализация шаблона "Производитель-Потребитель": Напишите программу, демонстрирующую взаимодействие производителя
и потребителя через общий буфер.*/

class Data {
    String value;
    boolean ready = false;

    synchronized String getValue() throws InterruptedException {
        while (!ready) {
            wait();
        }
        ready = false;
        notify();
        return value;
    }

    synchronized void setValue(String s) throws InterruptedException {
        while (ready) {
            wait();
        }
        this.value = s;
        ready = true;
        notify();
    }
}

public class Task7 {
    public static void main(String[] args) throws InterruptedException {

        Data data = new Data();

        Thread producer = new Thread(() -> {
            try {
                String[] strings = {"HOLA", "PIPU", "POPIFU"};
                for (String str : strings) {
                    data.setValue(str);
                    System.out.println("Производитель создал " + str);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread consumer = new Thread(() -> {
            try {
                for (int i = 0; i < 3; i++) {
                    String s = data.getValue();
                    System.out.println("Получатель принял " + s);
                    Thread.sleep(1400);
                }

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        producer.start();
        consumer.start();

        producer.join();
        consumer.join();
    }
}
