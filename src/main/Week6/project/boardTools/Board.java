package src.main.Week6.project.boardTools;

public class Board {

    private Cell[][] playingField;

    public Board() {
        playingField = new Cell[10][10];

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                playingField[i][j] = new Cell(new Coordinate(i, j));
                getCell(new Coordinate(i, j)).setCellState(CellState.EMPTY);
            }
        }
    }

    public Cell getCell(Coordinate coordinate) {
        return playingField[coordinate.getX()][coordinate.getY()];
    }

    public void setCellState(Coordinate coordinate, CellState state) {
        playingField[coordinate.getX()][coordinate.getY()].setCellState(state);
    }

    public void printBoard() {
        final String RESET = "\u001B[0m";
        final String GREEN = "\u001B[32m";
        final String RED = "\u001B[31m";
        final String YELLOW = "\u001B[33m";

        final String EMPTY_CELL = ".";

        System.out.println("    1  2  3  4  5  6  7  8  9  10");

        for (int i = 0; i < 10; i++) {
            System.out.print(String.format("%2d ", i + 1));
            for (int j = 0; j < 10; j++) {
                switch (playingField[i][j].getCellState()) {
                    case EMPTY -> System.out.print(EMPTY_CELL + "  "); // Заменено на точку
                    case SHIP -> System.out.print(GREEN + "🚢" + RESET + " ");
                    case HIT_ON_SHIP -> System.out.print(RED + "💥" + RESET + " ");
                    case MISS_HIT -> System.out.print(YELLOW + "❌" + RESET + " ");
                }
            }
            System.out.println();
        }
    }

    public Cell[][] getPlayingField() {
        return playingField;
    }
}
