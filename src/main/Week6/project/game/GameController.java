package src.main.Week6.project.game;

import src.main.Week6.project.Player;
import src.main.Week6.project.boardTools.Board;
import src.main.Week6.project.boardTools.Coordinate;
import src.main.Week6.project.ships.Fleet;

public class GameController implements IGameController {

    private final ClassicGameRules classicGameRules;
    private final GameState gameState;

    public GameController(IGameRules iGameRules, ClassicGameRules classicGameRules, GameState gameState) {
        this.classicGameRules = classicGameRules;
        this.gameState = gameState;
    }

    @Override
    public void startGame(Player player1, Player player2) {
        System.out.println("Игра началась, первым ходит игрок " + gameState.getCurrentPlayer().getName());
        gameState.setStatus(GameStatus.IN_PROGRESS);
    }

    @Override
    public ShotResult makeMove(Player player, Coordinate coordinate) {
        if (!player.equals(gameState.getCurrentPlayer())) {
            throw new IllegalStateException("Сейчас не ваш ход!");
        }

        Board opponentBoard = getOpponentBoard(player);

        ShotResult result = classicGameRules.checkShot(opponentBoard, coordinate);
        System.out.println("Игрок " + player.getName() + " выстрелил в " + coordinate + ": " + result);

        if (result == ShotResult.SUNK) {
            Fleet opponentFleet = getOpponentFleet(player);
            if (classicGameRules.isFleetSunk(opponentFleet)) {
                gameState.setStatus(GameStatus.COMPLETED);
                System.out.println("Игра завершена! Победитель: " + player.getName());
                return result;
            }
        }

        // Если игра не завершена, переключаем ход
        if (gameState.getStatus() == GameStatus.IN_PROGRESS) {
            gameState.switchTurn();
            System.out.println("Ход передан игроку: " + gameState.getCurrentPlayer().getName());
        }

        return result;
    }

    @Override
    public GameState getGameState() {
        return gameState;
    }
    private Board getOpponentBoard(Player player) {
        return player.equals(gameState.getPlayer1()) ? gameState.getBoardPlayer2() : gameState.getBoardPlayer1();
    }

    private Fleet getOpponentFleet(Player player) {
        return player.equals(gameState.getPlayer1()) ? gameState.getFleetPlayer2() : gameState.getFleetPlayer1();
    }
}
