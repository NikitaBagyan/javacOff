package src.main.Week3.project;

public class Audience {

    private Types types;
    private String roomNumber;

    public Audience(Types types, String roomNumber) {
        this.types = types;
        this.roomNumber = roomNumber;
    }

    public Types getTypes() {
        return types;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    @Override
    public String toString() {
        return "Аудитория " + roomNumber + " (" + types + ")";
    }
}

