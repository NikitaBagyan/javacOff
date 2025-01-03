package src.main.Week6.project;

import src.main.Week6.project.boardTools.Board;
import src.main.Week6.project.ships.Fleet;

public class Player {

    String name;
    Board board;
    Fleet fleet;

    public Player(String name, Board board, Fleet fleet) {
        this.name = name;
        this.board = board;
        this.fleet = fleet;
    }

    public String getName() {
        return name;
    }

    public Board getBoard() {
        return board;
    }

    public Fleet getFleet() {
        return fleet;
    }
}
