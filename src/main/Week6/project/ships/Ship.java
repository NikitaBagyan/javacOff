package src.main.Week6.project.ships;

import src.main.Week6.project.boardTools.Coordinate;

import java.util.List;

public class Ship {

    private final int lenght;
    private List<Coordinate> occupiedCells;
    private int hit = 0;

    public Ship(int lenght) {
        this.lenght = lenght;
    }

    public boolean isHit(Coordinate coordinate) {
        if (occupiedCells.stream()
                .anyMatch(value -> value.getY() == coordinate.getY() &&
                        value.getX() == coordinate.getX())) {
            hit++;
            return true;
        } else return false;
    }

    public void addOccupiedCells(Coordinate element) {
        occupiedCells.add(element);
    }

    public boolean isSunk() {
        if (hit == lenght) {
            return true;
        } else return false;
    }

    public int getLenght() {
        return lenght;
    }
}
