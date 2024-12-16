package src.main.Week6.project;

public enum Direction {

    HORIZONTAL("horizontal"),
    VERTICAL("vertical");

    private final String description;

    // Конструктор для каждого элемента
    Direction(String description) {
        this.description = description;
    }

    // Метод для получения описания
    public String getDescription() {
        return description;
    }
}


