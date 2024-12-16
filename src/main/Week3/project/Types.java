package src.main.Week3.project;

public enum Types {

    LECTURE("Lecture"),
    SEMINAR("Seminar"),
    LABORATORY("Laboratory");


    private final String type;

    Types(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return type;
    }
}
