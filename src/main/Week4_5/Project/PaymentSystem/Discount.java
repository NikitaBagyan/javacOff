package src.main.Week4_5.Project.PaymentSystem;

import java.util.HashMap;
import java.util.Map;

public class Discount {
    private final Map<String, Integer> discounts = new HashMap<>();

    public void applyDiscount(String vehicleNumber) {
        discounts.put(vehicleNumber, discounts.getOrDefault(vehicleNumber, 0) + 5); // +5% за каждое посещение
    }

    public int getDiscount(String vehicleNumber) {
        return Math.min(discounts.getOrDefault(vehicleNumber, 0), 50); // Максимальная скидка: 50%
    }
}
