package src.main;

import java.util.ArrayList;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<>();
        String[][] template = {
                {"A", "1", "0", "1", "B"},
                {"2", "3", "0", "1", "0"},
                {"0", "A", "1", "0", "0"},
                {"1", "0", "B", "0", "1"},
                {"B", "1", "0", "0", "A"}
        };

        int x = 0;
        int y = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if(i == 0 && j == 0) continue;
                int xi = x + i;
                int yj = y + j;

                if(xi >= 0 && yj >= 0 && xi < template.length && yj < template[0].length) {
                    System.out.println(template[xi][yj]);
                }

            }
        }
    }

}
