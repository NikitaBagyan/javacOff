package src.main.Week1.MinNumber;

public class MinFinder {

    int findMin(int a, int b, int c) {
        if (a < b && a < c) {
            return a;
        }
        if (b < a && b < c) {
            return b;
        } else return c;
    }
}
