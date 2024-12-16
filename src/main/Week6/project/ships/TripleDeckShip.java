package src.main.Week6.project.ships;

import src.main.Week6.project.boardTools.Coordinate;

import java.util.List;

public class TripleDeckShip extends Ship {
    public TripleDeckShip(int lenght, List<Coordinate> occupiedCells) {
        super(ShipLenght.TRIPLE_DECK_LENGHT.getDescription());
    }
}
