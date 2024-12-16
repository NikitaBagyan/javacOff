package src.main.Week4_5.Homework;

import java.util.ArrayList;
import java.util.List;

public class Map {
    private Cell[][] map;

    public Map(String[][] template, List<Colony> colonies) {
        int rows = template.length;
        int cols = template[0].length;
        map = new Cell[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                String cellValue = template[i][j];
                if (cellValue.equals("0")) {
                    map[i][j] = new Cell(CellTypes.EMPTY, null, 0, i, j, this);
                } else if (cellValue.equals("1")) {
                    map[i][j] = new Cell(CellTypes.WALL, null, 0, i, j, this);
                } else {
                    Colony colony = colonies.stream()
                            .filter(c -> c.getName().equals(cellValue))
                            .findFirst().orElse(null);

                    map[i][j] = new Cell(CellTypes.CIVILIZATION, colony, 500, i, j, this);
                    if (colony != null) colony.addCell(map[i][j]);
                }
            }
        }
    }

    public Cell[][] getMap() {
        return map;
    }

    public void drawMap() {
        for (Cell[] row : map) {
            for (Cell cell : row) {
                if (cell.getColony() != null) {
                    System.out.print(cell.getColony().getName());
                } else if (cell.getCellTypes() == CellTypes.WALL) {
                    System.out.print("█");
                } else {
                    System.out.print(".");
                }
            }
            System.out.println();
        }
    }

    public List<Cell> getNeighbors(int x, int y) {
        List<Cell> neighbors = new ArrayList<>();
        for (int dx = -1; dx <= 1; dx++) {
            for (int dy = -1; dy <= 1; dy++) {
                if (dx == 0 && dy == 0) continue;

                int nx = x + dx;
                int ny = y + dy;

                if (nx >= 0 && ny >= 0 && nx < map.length && ny < map[0].length) {
                    neighbors.add(map[nx][ny]);
                }
            }
        }
        return neighbors;
    }
}
