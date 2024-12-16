package src.main.Week6.project.ships;

public enum ShipLenght {

    SINGLE_DECK_LENGHT(1),
    DOUBLE_DECK_LENGHT(2),
    TRIPLE_DECK_LENGHT(3),
    QUADRUPLE_DECK_LENGHT(4);

    private final int description;

    // Конструктор для каждого элемента
    ShipLenght(int description) {
        this.description = description;
    }

    // Метод для получения описания
    public int getDescription() {
        return description;
    }
}


