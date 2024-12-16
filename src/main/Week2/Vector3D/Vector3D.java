package src.main.Week2.Vector3D;

public class Vector3D {
    private double x;
    private double y;
    private double z;

    public Vector3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector3D() {
        this.x = 0.0;
        this.y = 0.0;
        this.z = 0.0;
    }

    double getMagnitude() {
        return Math.sqrt(this.x * this.x + this.y * this.y + this.z * this.z);
    }

    Vector3D add(Vector3D other) {
        double resultX = this.x + other.x;
        double resultY = this.y + other.y;
        double resultZ = this.z + other.z;
        return new Vector3D(resultX, resultY, resultZ);
    }

    Vector3D subtract(Vector3D other) {
        double resultX = this.x - other.x;
        double resultY = this.y - other.y;
        double resultZ = this.z - other.z;
        return new Vector3D(resultX, resultY, resultZ);
    }

    double dotProduct(Vector3D other) {
        return this.x * other.x + this.y * other.y + this.z * other.z;
    }

    static Vector3D add(Vector3D a, Vector3D b) {
        double resultX = a.x + b.x;
        double resultY = a.y + b.y;
        double resultZ = a.z + b.z;
        return new Vector3D(resultX, resultY, resultZ);
    }

    static Vector3D subtract(Vector3D a, Vector3D b) {
        double resultX = a.x - b.x;
        double resultY = a.y - b.y;
        double resultZ = a.z - b.z;
        return new Vector3D(resultX, resultY, resultZ);
    }

    static double dotProduct(Vector3D a, Vector3D b) {
        return a.x * b.x + a.y * b.y + a.z * b.z;
    }

    public String toString() {
        return "Vector3D{x=" + this.x + ", y=" + this.y + ", z=" + this.z + "}";
    }
}
