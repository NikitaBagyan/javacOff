package src.main.Week4_5.Homework;

import java.util.Random;

public class ColonyTask implements Runnable {
    private final Colony colony;
    private final Map map;

    public ColonyTask(Colony colony, Map map) {
        this.colony = colony;
        this.map = map;
    }

    @Override
    public void run() {
        Random random = new Random();

        for (int step = 0; step < 10; step++) {
            synchronized (map) {
                for (Cell cell : colony.getControlledCells()) {
                    cell.produceEnergy();
                }

                int x = random.nextInt(map.getMap().length);
                int y = random.nextInt(map.getMap()[0].length);

                Cell targetCell = map.getMap()[x][y];
                if (targetCell != null && targetCell.getColony() != colony) {
                    targetCell.attemptCapture(colony, 200);
                }
            }

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
