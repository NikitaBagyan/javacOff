package src.main.Week4_5.Project.Vehicle;

public enum VehicleType {

    CAR("Легковой автомобиль"),
    TRUCK("Грузовик");

    private final String description;

    // Конструктор для каждого элемента
    VehicleType(String description) {
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

