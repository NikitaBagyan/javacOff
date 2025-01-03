package src.main.Week6.project.placementServise;

import src.main.Week6.project.Direction;
import src.main.Week6.project.Player;
import src.main.Week6.project.boardTools.Board;
import src.main.Week6.project.boardTools.Cell;
import src.main.Week6.project.boardTools.CellState;
import src.main.Week6.project.boardTools.Coordinate;
import src.main.Week6.project.ships.Ship;

public class ShipPlacementService implements IShipPlacementService {

    @Override
    public boolean placeShip(Board board, Ship ship, Coordinate start, Direction direction) {
        if (canPlaceShip(board, ship, start, direction)) {
            System.out.println("Ваш корабль установлен на следующие точки: ");
            for (int i = 0; i < ship.getLenght(); i++) {
                Coordinate coordinate = new Coordinate(start.getX() + (direction == Direction.VERTICAL ? i : 0), start.getY() + (direction == Direction.HORIZONTAL ? i : 0));
                takeCell(coordinate, board, ship);
                shipPlacement(coordinate, ship);
                System.out.println(coordinate);
            }
            return true;
        }
        System.out.println("Нельзя разместить корабль по выбранным вам координатам");
        return false;
    }

    @Override
    public boolean canPlaceShip(Board board, Ship ship, Coordinate start, Direction direction) {
        return startCoordinateValidation(start)
                && shipCompletelyField(board, ship, start, direction)
                && cellsFree(board, ship, start, direction)
                && noTouchingShip(board, ship, start, direction);
    }

    @Override
    public boolean startCoordinateValidation(Coordinate start) {
        return start.getX() >= 0
                && start.getX() <= 9
                && start.getY() >= 0
                && start.getY() <= 9;                //проверка начальной координаты
    }

    @Override
    public boolean shipCompletelyField(Board board, Ship ship, Coordinate start, Direction direction) {         //Метод проверки направления для корабля
        if (direction.equals(Direction.HORIZONTAL)) {
            return shipCompletelyFieldHorizontal(board, ship, start, direction);
        }
        return shipCompletelyFieldVertical(board, ship, start, direction);
    }

    @Override
    public boolean cellsFree(Board board, Ship ship, Coordinate start, Direction direction) {                   //Метод проверки клеток на пустоту
        for (int i = 0; i < ship.getLenght(); i++) {
            int currentX = start.getX();
            int currentY = start.getY();

            if (direction == Direction.HORIZONTAL) {
                currentX = start.getX() + i;
            } else if (direction == Direction.VERTICAL) {
                currentY = start.getY() + i;
            }

            CellState cellState = board.getCell(new Coordinate(currentX, currentY)).getCellState();
            if (cellState != CellState.EMPTY) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean noTouchingShip(Board board, Ship ship, Coordinate start, Direction direction) {     //Проверяем не касаемся ли мы других кораблей
        int x = start.getX();
        int y = start.getY();

        for (int i = 0; i < ship.getLenght(); i++) {
            int currentX = x + (direction == Direction.HORIZONTAL ? i : 0);
            int currentY = y + (direction == Direction.VERTICAL ? i : 0);

            for (int dx = -1; dx <= 1; dx++) {
                for (int dy = -1; dy <= 1; dy++) {
                    int nx = currentX + dx;
                    int ny = currentY + dy;
                    if (nx < 0 || nx > 9 || ny < 0 || ny > 9) {
                        continue;                                                                       // Пропускаем клетки вне поля
                    }
                    CellState cellState = board.getCell(new Coordinate(nx, ny)).getCellState();
                    if (cellState == CellState.SHIP) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private void takeCell(Coordinate coordinate, Board board, Ship ship) {
        board.getCell(coordinate).setCellState(CellState.SHIP);
        board.getCell(coordinate).setShip(ship);
    }

    private void shipPlacement(Coordinate coordinate, Ship ship) {
        ship.addOccupiedCells(coordinate);
    }

    private boolean shipCompletelyFieldHorizontal(Board board, Ship ship, Coordinate start, Direction direction) {           //Эти два метода проверяют получится ли у нас поставить корабль по выбранному направлению
        Coordinate lastDeck = new Coordinate(start.getX() + ship.getLenght() - 1, start.getY());
        return lastDeck.getX() >= 0
                && lastDeck.getX() <= 9
                && lastDeck.getY() >= 0
                && lastDeck.getY() <= 9;
    }

    private boolean shipCompletelyFieldVertical(Board board, Ship ship, Coordinate start, Direction direction) {
        Coordinate lastDeck = new Coordinate(start.getX(), start.getY() + ship.getLenght() - 1);
        return lastDeck.getX() >= 0
                && lastDeck.getX() <= 9
                && lastDeck.getY() >= 0
                && lastDeck.getY() <= 9;
    }
}
