package src.main.Week4_5.Homework;

import java.util.List;

public class Cell {

    public static final int MAX_ENERGY = 10000;
    private static final int MIN_ENERGY = 100;
    private final int BASE_ENERGY = 10;

    private CellTypes cellTypes;
    private Colony colony;
    private int energy;
    private final int x, y;
    private Map map;
    private List<Cell> neighbors;

    public Cell(CellTypes cellTypes, Colony colony, int energy, int x, int y, Map map) {
        this.cellTypes = cellTypes;
        this.colony = colony;
        this.energy = energy;
        this.x = x;
        this.y = y;
        this.map = map;
        this.neighbors = map.getNeighbors(x, y); // Кешируем соседей
    }

    public Colony getColony() {
        return colony;
    }

    public CellTypes getCellTypes() {
        return cellTypes;
    }

    public void setColony(Colony colony) {
        this.colony = colony;
    }

    public void produceEnergy() {
        if (colony == null || cellTypes != CellTypes.CIVILIZATION) return;

        int bonusEnergy = 5 * countAlliedNeighbors();
        this.energy += BASE_ENERGY + bonusEnergy;

        if (energy > MAX_ENERGY) {
            int overlimit = energy - MAX_ENERGY;
            energy = MAX_ENERGY;
            transferEnergy(overlimit);
        }
    }

    private int countAlliedNeighbors() {
        int count = 0;
        for (Cell neighbor : neighbors) {
            if (neighbor != null && neighbor.colony == this.colony) {
                count++;
            }
        }
        return count;
    }

    private void transferEnergy(int extraEnergy) {
        for (Cell neighbor : neighbors) {
            if (neighbor != null && neighbor.colony == this.colony) {
                int availableSpace = MAX_ENERGY - neighbor.energy;
                if (availableSpace > 0) {
                    int transfer = Math.min(extraEnergy, availableSpace);
                    neighbor.energy += transfer;
                    extraEnergy -= transfer;
                }
                if (extraEnergy == 0) return;
            }
        }
        if (extraEnergy > 0) {
            colony.increaseEnergy(extraEnergy); // Остаток энергии идет в колонию
        }
    }

    public boolean attemptCapture(Colony attacker, int energyToSpend) {
        if (this.colony == attacker) return false;

        int requiredEnergy = (int) (energy * 1.5);
        if (attacker.getEnergy() >= requiredEnergy) {
            if (colony != null) colony.removeCell(this);

            colony = attacker;
            colony.addCell(this);

            attacker.reduceEnergy(requiredEnergy);
            energy = Math.max(0, MIN_ENERGY);      // Ячейка остается с минимальной энергией

            return true;
        }
        return false;
    }
}
