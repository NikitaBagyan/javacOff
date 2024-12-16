package src.main.Week6.project.ships;

import src.main.Week6.project.boardTools.Coordinate;

import java.util.List;

public class DoubleDeckShip extends Ship {

    public DoubleDeckShip(int lenght, List<Coordinate> occupiedCells) {
        super(lenght = ShipLenght.DOUBLE_DECK_LENGHT.getDescription());
    }
}
