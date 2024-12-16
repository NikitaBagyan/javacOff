package src.main.Week1.Circle;

//Класс "Круг"Создайте класс Circle с полем радиус и методами для вычисления площади и окружности. Реализуйте инкапсуляцию и создайте соответствующие геттеры и сеттеры.


public class Circle {

    private double radius;


    double square(){

        return Math.PI * (radius * radius);
    }

    double circle(){

        return 2 * Math.PI * radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}
