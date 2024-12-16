package src.main.Week6.project.boardTools;

public class Board {

    private Cell[][] playingField;

    public Board() {
        playingField = new Cell[10][10];

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                playingField[i][j] = new Cell(new Coordinate(i,j));
            }
        }
    }

    public Cell getCell(Coordinate coordinate) {
        return playingField[coordinate.getX()][coordinate.getY()];
    }

    public void setCellState(Coordinate coordinate, CellState state) {
        playingField[coordinate.getX()][coordinate.getY()].setCellState(state);
    }

    public Cell[][] getPlayingField() {
        return playingField;
    }
}
