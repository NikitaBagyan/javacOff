package src.main.SkillFactory.Telemessage;

/*В системе телетекста сообщения посылаются на экран посимвольно, с задержкой в полсекунды.
Возникла необходимость одновременной трансляции с нескольких источников.
То есть одновременно может быть запущено несколько потоков.
Естественно, при этом символы сообщений не должны перемешиваться (сначала одно сообщение должно выводиться полностью, потом второе и т.д.)

Оформите решение в виде класса Typer подкласса Thread, принимающего в конструкторе сообщение и выводящего это сообщение.
Сделайте так, чтобы вывод сообщений не перемешивался.
Предусмотрите корректное прерывание потока. Получив команду interrupt(), поток должен просто закончить работу.

То есть при запуске такой программы:

        new Typer("Message first. ").start();
new Typer("Message second.").start();
Сообщения начали постепенно появляться и через 15 секунд в консоли появилась надпись:
Message first. Message second.*/

public class Typer extends Thread {

    static Object lock = new Object();

    String message;

    public Typer(String message) {
        this.message = message;
    }

    @Override
    public void run() {
            synchronized (lock) {
                for (int i = 0; i < message.length(); i++) {
                    System.out.println(message.charAt(i));
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        break;
                    }

                }
        }
    }
}
