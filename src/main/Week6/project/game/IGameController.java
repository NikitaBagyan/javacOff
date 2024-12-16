package src.main.Week6.project.game;

import src.main.Week6.project.Player;
import src.main.Week6.project.boardTools.Coordinate;

public interface IGameController {
        void startGame(Player player1, Player player2);
        ShotResult makeMove(Player player, Coordinate coordinate);
        GameState getGameState();
}