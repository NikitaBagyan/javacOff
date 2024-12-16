package src.main.Week6.project;

import src.main.Week6.project.boardTools.Board;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Board board = new Board();
        Arrays.stream(board.getPlayingField())
                .forEach(row -> System.out.println(Arrays.toString(row)));
    }
}
