package src.main.Week3.libraries;

import java.util.ArrayList;
import java.util.List;

public class Renter {

    String name;
    int id;
    public List<RentInfo> infoList = new ArrayList<>();

    public Renter(String name, int id) {
        this.name = name;
        this.id = id;
    }

    void printRentHistory() {
        infoList.forEach(System.out::println);
    }
}
