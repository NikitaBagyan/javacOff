package src.main.Week4_5.Homework;

public enum CellTypes {

    WALL("wall"),
    EMPTY("empty"),
    CIVILIZATION("civilization");

    private final String description;

    // Конструктор для каждого элемента
    CellTypes(String description) {
        this.description = description;
    }

    // Метод для получения описания
    public String getDescription() {
        return description;
    }

    // Переопределение toString для удобного вывода
    @Override
    public String toString() {
        return name() + " (" + description + ")";
    }
}
