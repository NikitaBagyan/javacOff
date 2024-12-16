package src.main.Week6.project.game;

import src.main.Week6.project.boardTools.Board;
import src.main.Week6.project.boardTools.Coordinate;
import src.main.Week6.project.ships.Fleet;

public interface IGameRules {

    ShotResult checkShot(Board board, Coordinate c);
    boolean isFleetSunk(Fleet fleet);
}
