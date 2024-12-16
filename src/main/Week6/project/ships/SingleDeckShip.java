package src.main.Week6.project.ships;

import src.main.Week6.project.boardTools.Coordinate;

import java.util.List;

public class SingleDeckShip extends Ship{

    public SingleDeckShip(int lenght, List<Coordinate> occupiedCells) {
        super(ShipLenght.SINGLE_DECK_LENGHT.getDescription());
    }
}
