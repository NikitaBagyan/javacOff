package src.main.Week6.project.boardTools;

public enum CellState {

    EMPTY("empty"),
    SHIP("ship"),
    HIT_ON_SHIP("hit_on_ship"),
    MISS_HIT("miss_hit");

    private final String description;

    // Конструктор для каждого элемента
    CellState(String description) {
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
