package src.main.Week6.project.placementServise;

import src.main.Week6.project.Direction;
import src.main.Week6.project.boardTools.Board;
import src.main.Week6.project.boardTools.Coordinate;
import src.main.Week6.project.ships.Ship;

/**
 * Интерфейс отвечает за размещение кораблей на борде, содержит методы валидации, которые гарантируют постановку корбаля согласно правилам
 **/
public interface IShipPlacementService {

    boolean placeShip(Board board, Ship ship, Coordinate start, Direction direction);

    boolean canPlaceShip(Board board, Ship ship, Coordinate start, Direction direction);

    boolean startCoordinateValidation(Coordinate start);

    boolean shipCompletelyField(Board board, Ship ship, Coordinate start, Direction direction);

    boolean cellsFree(Board board, Ship ship, Coordinate start, Direction direction);

    boolean noTouchingShip(Board board, Ship ship, Coordinate start, Direction direction);
}
