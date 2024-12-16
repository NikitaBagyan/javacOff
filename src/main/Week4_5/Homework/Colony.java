package src.main.Week4_5.Homework;

import java.util.HashSet;
import java.util.Set;

public class Colony {
    private final String name;
    private int energy;
    private Set<Cell> controlledCells;

    public Colony(String name, int initialEnergy) {
        this.name = name;
        this.energy = initialEnergy;
        this.controlledCells = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public int getEnergy() {
        return energy;
    }

    public void reduceEnergy(int amount) {
        energy = Math.max(0, energy - amount);
    }

    public void increaseEnergy(int amount) {
        energy += amount;
    }

    public Set<Cell> getControlledCells() {
        return controlledCells;
    }

    public void addCell(Cell cell) {
        controlledCells.add(cell);
    }

    public void removeCell(Cell cell) {
        controlledCells.remove(cell);
    }
}
