package src.main.Week6.project.boardTools;

import src.main.Week6.project.ships.Ship;

public class Cell {

    private CellState cellState;
    private Ship ship;
    private Coordinate coordinate;

    public Cell(Coordinate coordinate) {
        this.coordinate = coordinate;
        this.ship = null;
    }

    public Ship getShip() {
        return ship;
    }

    public void setShip(Ship ship) {
        this.ship = ship;
    }

    public void setCellState(CellState cellState) {
        this.cellState = cellState;
    }

    public CellState getCellState() {
        return cellState;
    }
}