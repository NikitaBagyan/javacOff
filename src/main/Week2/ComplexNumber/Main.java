package src.main.Week2.ComplexNumber;

public class Main {

    public static void main(String[] args) {
        ComplexNumber num1 = new ComplexNumber(3.0, 4.0);
        ComplexNumber num2 = new ComplexNumber(2.0, -1.0);
        ComplexNumber sum1 = num1.add(num2);
        ComplexNumber difference1 = num1.subtract(num2);
        ComplexNumber sum2 = ComplexNumber.add(num1, num2);
        ComplexNumber difference2 = ComplexNumber.subtract(num1, num2);
        System.out.println("Magnitude of num1: " + num1.getMagnitude());
        System.out.println("Sum1: " + String.valueOf(sum1));
        System.out.println("Difference1: " + String.valueOf(difference1));
        System.out.println("Sum2: " + String.valueOf(sum2));
        System.out.println("Difference2: " + String.valueOf(difference2));
    }
}
