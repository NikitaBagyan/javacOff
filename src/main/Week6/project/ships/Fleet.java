package src.main.Week6.project.ships;

import java.util.ArrayList;
import java.util.List;

public class Fleet {

    private List<Ship> shipList = new ArrayList<>();

    public void addShip(Ship ship) {
        shipList.add(ship);
    }

    public boolean isAllSunk() {
        return shipList.stream().allMatch(value -> value.isSunk());
    }
}
