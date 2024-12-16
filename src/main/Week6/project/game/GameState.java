package src.main.Week6.project.game;

import src.main.Week6.project.Player;
import src.main.Week6.project.boardTools.Board;
import src.main.Week6.project.ships.Fleet;

import java.util.Objects;

public class GameState {
    private Board boardPlayer1;
    private Board boardPlayer2;
    private Fleet fleetPlayer1;
    private Fleet fleetPlayer2;
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private GameStatus status;

    void switchTurn() {
        if (Objects.equals(currentPlayer, player1)) {
            currentPlayer = player2;
        } else currentPlayer = player1;
    }

    boolean isGameOver() {
        return currentPlayer.getFleet().isAllSunk();
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public Board getBoardPlayer1() {
        return boardPlayer1;
    }

    public Board getBoardPlayer2() {
        return boardPlayer2;
    }

    public Fleet getFleetPlayer1() {
        return fleetPlayer1;
    }

    public Fleet getFleetPlayer2() {
        return fleetPlayer2;
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public GameStatus getStatus() {
        return status;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public void setStatus(GameStatus status) {
        this.status = status;
    }

}
