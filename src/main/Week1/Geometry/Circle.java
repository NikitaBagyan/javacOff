package src.main.Week1.Geometry;

public class Circle extends Shape {

    protected void square(double radius) {

        double result = Math.PI * (radius * radius);
        System.out.println(result);
    }

    @Override
    protected void perimetr() {
        super.perimetr();
    }
}
