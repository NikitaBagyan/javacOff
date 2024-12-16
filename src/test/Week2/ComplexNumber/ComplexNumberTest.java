package src.test.Week2.ComplexNumber;

import org.junit.jupiter.api.Test;
import src.main.Week2.ComplexNumber.ComplexNumber;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ComplexNumberTest {
    ComplexNumberTest() {
    }

    @Test
    void testConstructorWithParameters() {
        ComplexNumber number = new ComplexNumber(3.0, 4.0);
        assertEquals(3.0, number.real);
        assertEquals(4.0, number.imaginary);
    }

    @Test
    void testConstructorWithoutParameters() {
        ComplexNumber number = new ComplexNumber();
        assertEquals(0.0, number.real);
        assertEquals(0.0, number.imaginary);
    }

    @Test
    void testGetMagnitude() {
        ComplexNumber number = new ComplexNumber(3.0, 4.0);
        assertEquals(5.0, number.getMagnitude(), 1.0E-4);
    }

    @Test
    void testAddInstanceMethod() {
        ComplexNumber number1 = new ComplexNumber(1.0, 2.0);
        ComplexNumber number2 = new ComplexNumber(3.0, 4.0);
        ComplexNumber result = number1.add(number2);
        assertEquals(4.0, result.real);
        assertEquals(6.0, result.imaginary);
    }

    @Test
    void testSubtractInstanceMethod() {
        ComplexNumber number1 = new ComplexNumber(5.0, 6.0);
        ComplexNumber number2 = new ComplexNumber(3.0, 4.0);
        ComplexNumber result = number1.subtract(number2);
        assertEquals(2.0, result.real);
        assertEquals(2.0, result.imaginary);
    }

    @Test
    void testAddStaticMethod() {
        ComplexNumber number1 = new ComplexNumber(1.0, 1.0);
        ComplexNumber number2 = new ComplexNumber(2.0, 2.0);
        ComplexNumber result = ComplexNumber.add(number1, number2);
        assertEquals(3.0, result.real);
        assertEquals(3.0, result.imaginary);
    }

    @Test
    void testSubtractStaticMethod() {
        ComplexNumber number1 = new ComplexNumber(5.0, 5.0);
        ComplexNumber number2 = new ComplexNumber(2.0, 2.0);
        ComplexNumber result = ComplexNumber.subtract(number1, number2);
        assertEquals(3.0, result.real);
        assertEquals(3.0, result.imaginary);
    }

    @Test
    void testToString() {
        ComplexNumber number = new ComplexNumber(3.0, 4.0);
        assertEquals("ComplexNumber{imaginary=4.0, real=3.0}", number.toString());
    }
}
