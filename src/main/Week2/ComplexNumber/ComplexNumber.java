package src.main.Week2.ComplexNumber;

public class ComplexNumber {
    public double real;
    public double imaginary;

    public ComplexNumber(double real, double imaginary) {
        this.imaginary = imaginary;
        this.real = real;
    }

    public ComplexNumber() {
       imaginary = imaginary;
       real = real;
    }

    public double getMagnitude() {
        return Math.sqrt(real * real + imaginary * imaginary);
    }

    public ComplexNumber add(ComplexNumber other) {
        return new ComplexNumber(real + other.real, imaginary + other.imaginary);
    }

    public ComplexNumber subtract(ComplexNumber other) {
        return new ComplexNumber(real - other.real, imaginary - other.imaginary);
    }

    public static ComplexNumber add(ComplexNumber a, ComplexNumber b) {
        double resultImaginary = a.imaginary + b.imaginary;
        double resultReal = a.real + b.real;
        return new ComplexNumber(resultReal, resultImaginary);
    }

    public static ComplexNumber subtract(ComplexNumber a, ComplexNumber b) {
        double resultImaginary = a.imaginary - b.imaginary;
        double resultReal = a.real - b.real;
        return new ComplexNumber(resultReal, resultImaginary);
    }

    public String toString() {
        return "ComplexNumber{imaginary=" + imaginary + ", real=" + real + "}";
    }
}
