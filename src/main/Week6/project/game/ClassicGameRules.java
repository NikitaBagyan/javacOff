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
        switch (cell.getCellState()) {
            case EMPTY -> shotResult = ShotResult.MISS;
            case SHIP -> shotResult = ShotResult.HIT;
            default -> throw new IllegalArgumentException();
        }
        return shotResult;
    }

    @Override
    public boolean isFleetSunk(Fleet fleet) {
        return fleet.isAllSunk();
    }
}
