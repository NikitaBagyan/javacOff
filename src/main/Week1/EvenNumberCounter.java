package src.main.Week1;

public class EvenNumberCounter {

    public static void main(String[] args) {

        int counterEvenNumber = 0;
        for (int i = 1; i < 100; i++) {

            if(i % 2 == 0){
                counterEvenNumber++;
                System.out.println(i);
            }
        }
        System.out.println("Четных чисел всего " + counterEvenNumber);
    }
}
