package src.main.Week6.project;

import src.main.Week6.project.boardTools.Board;
import src.main.Week6.project.boardTools.Coordinate;
import src.main.Week6.project.game.ClassicGameRules;
import src.main.Week6.project.game.GameController;
import src.main.Week6.project.game.GameState;
import src.main.Week6.project.placementServise.ShipPlacementService;
import src.main.Week6.project.ships.DoubleDeckShip;
import src.main.Week6.project.ships.Fleet;
import src.main.Week6.project.ships.QuadrupleDeckShip;
import src.main.Week6.project.ships.TripleDeckShip;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Board board1 = new Board();
        Board board2 = new Board();

        Player player1 = new Player("Васек", board1, new Fleet());
        Player player2 = new Player("Игорек", board2, new Fleet());


        Fleet fleet1 = new Fleet();
        Fleet fleet2 = new Fleet();

        ShipPlacementService shipPlacementService = new ShipPlacementService();
        GameState gameState = new GameState(board1, board2, fleet1, fleet2, player1, player2);
        GameController gameController = new GameController(new ClassicGameRules(), gameState);

        gameController.startGame();
        gameController.getGameState();
        gameController.makeMove(player1, new Coordinate(1, 1));
        gameController.getOpponentBoard(player1).printBoard();


    }
}
