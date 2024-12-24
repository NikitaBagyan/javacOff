package src.main.Week6.project.game;

import src.main.Week6.project.boardTools.Board;
import src.main.Week6.project.boardTools.Cell;
import src.main.Week6.project.boardTools.CellState;
import src.main.Week6.project.boardTools.Coordinate;
import src.main.Week6.project.ships.Fleet;

public class ClassicGameRules implements IGameRules {

    private Cell cell;
    private ShotResult shotResult;

    @Override
    public ShotResult checkShot(Board board, Coordinate coordinate) {
        cell = board.getCell(coordinate);
        if (cell.getCellState() == CellState.SHIP) {
            hitRegister(board, coordinate);
            if (cell.getShip().isSunk()) {
                return ShotResult.SUNK;
            }
            return ShotResult.HIT;
        }
        cell.setCellState(CellState.MISS_HIT);
        return ShotResult.MISS;
    }

    @Override
    public boolean isFleetSunk(Fleet fleet) {
        return fleet.isAllSunk();
    }

    private void hitRegister(Board board, Coordinate coordinate) {
        cell.getShip().isHit(coordinate);
        cell.setCellState(CellState.HIT_ON_SHIP);
    }
}
