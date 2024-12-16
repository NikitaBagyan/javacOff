package src.main.SkillFactory;

public class StackFrame {
    static class Answer {
        final int value = 42;
    }

    static class LifeUniverseEverything {
        static final Answer ANSWER = new Answer();
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(
                StackFrame::findAnswerToLifeTheUniverseAndEverything, "thread1");
        Thread thread2 = new Thread(() -> {
            while (true) {
            }
        }, "thread2");
        thread1.start();
        thread2.start();
    }

    public static void findAnswerToLifeTheUniverseAndEverything() {
        Answer answer = LifeUniverseEverything.ANSWER;
        System.out.println(answer.value);
    }
}

