package src.main.Week6.project.ships;

import src.main.Week6.project.boardTools.Coordinate;

import java.util.List;

public class QuadrupleDeckShip extends Ship{
    public QuadrupleDeckShip(int lenght, List<Coordinate> occupiedCells) {
        super(ShipLenght.QUADRUPLE_DECK_LENGHT.getDescription());
    }
}
