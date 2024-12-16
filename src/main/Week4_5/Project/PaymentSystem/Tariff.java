package src.main.Week4_5.Project.PaymentSystem;

public enum Tariff {
    NEW_CLIENT_TARIFF(10),              //по задумке клиенты будут платить по 10 за секунду а регулярные по 5
    PREMIUM_CLIENT_TARIFF(5),

    VISITS_FOR_PREMIUM_STATUS(3),                  //столько посещений нужно для премиума

    FREE_PARKING_TIME(5);               //бесплатно можно находится на парковке не более 5 секунд

    private final int description;

    Tariff(int description) {
        this.description = description;
    }

    public int getDescription() {
        return description;
    }
}
