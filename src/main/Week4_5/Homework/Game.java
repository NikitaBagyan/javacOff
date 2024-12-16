package src.main.Week4_5.Homework;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Game {
    private final Map map;
    private final List<Colony> colonies;

    public Game(Map map, List<Colony> colonies) {
        this.map = map;
        this.colonies = colonies;
    }

    public void start(int steps) {
        ExecutorService executor = Executors.newFixedThreadPool(colonies.size());

        for (Colony colony : colonies) {
            executor.submit(new ColonyTask(colony, map));
        }

        executor.shutdown();

        for (int i = 0; i < steps; i++) {
            synchronized (map) {
                System.out.println("Шаг " + (i + 1));
                map.drawMap();
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
