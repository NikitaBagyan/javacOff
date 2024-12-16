package src.main.Week3.project;

public enum TimeSlot {

    SLOT_1("9:00"),
    SLOT_2("11:00"),
    SLOT_3("13:00"),
    SLOT_4("15:00");

    private final String time;

    TimeSlot(String time) {
        this.time = time;
    }

    public String getTime() {
        return time;
    }

    @Override
    public String toString() {
        return time;
    }
}

