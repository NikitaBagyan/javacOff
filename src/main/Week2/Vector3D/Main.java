package src.main.Week2.Vector3D;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        Vector3D vector1 = new Vector3D(1.0, 2.0, 3.0);
        Vector3D vector2 = new Vector3D(4.0, -1.0, 2.0);
        Vector3D sum1 = vector1.add(vector2);
        Vector3D difference1 = vector1.subtract(vector2);
        double dotProduct1 = vector1.dotProduct(vector2);
        Vector3D sum2 = Vector3D.add(vector1, vector2);
        Vector3D difference2 = Vector3D.subtract(vector1, vector2);
        double dotProduct2 = Vector3D.dotProduct(vector1, vector2);
        System.out.println("Magnitude of vector1: " + vector1.getMagnitude());
        System.out.println("Sum1: " + String.valueOf(sum1));
        System.out.println("Difference1: " + String.valueOf(difference1));
        System.out.println("DotProduct1: " + dotProduct1);
        System.out.println("Sum2: " + String.valueOf(sum2));
        System.out.println("Difference2: " + String.valueOf(difference2));
        System.out.println("DotProduct2: " + dotProduct2);
    }
}

