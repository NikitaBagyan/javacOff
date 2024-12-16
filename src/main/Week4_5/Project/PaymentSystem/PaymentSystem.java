package src.main.Week4_5.Project.PaymentSystem;

import src.main.Week4_5.Project.ParkingManager.EntryQueue;
import src.main.Week4_5.Project.Vehicle.Vehicle;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.TimeUnit;

public class PaymentSystem {

    private Duration parkedTime;
    private EntryQueue entryQueue;

    public PaymentSystem(EntryQueue entryQueue) {
        this.entryQueue = entryQueue;
    }

    private Duration parkingStayTime(Vehicle vehicle) {
        Instant startParkingTime = vehicle.getStartParkingTime();
        Instant endParkingTime = Instant.now();
        parkedTime = Duration.between(startParkingTime, endParkingTime);
        System.out.println("Машина " + vehicle.getNumber() + " была на стоянке " + parkedTime.toSeconds() + " second"); //да, знаю))) на русском не подошло ни одно склонение а валидацию на число прикручивать не захотелось(
        return parkedTime;
    }

    public synchronized boolean validateClient(Vehicle vehicle) {
        parkedTime = parkingStayTime(vehicle);
        if (validateDurationParking(parkedTime)) {
            calculateParkingCost(parkedTime, vehicle);
            try {
                TimeUnit.SECONDS.sleep(1);
                pay(vehicle);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return true;
        }
        System.out.println("Машина " + vehicle.getNumber() + " прибывала на парковке в бесплатном промежутке");
        return false;
    }

    private boolean validateDurationParking(Duration duration) {                //если метод вернет true тогда клиент должен платить
        int seconds = Math.toIntExact(duration.toSeconds());
        return seconds >= Tariff.FREE_PARKING_TIME.getDescription();
    }

    private boolean validatePremiumClient(Vehicle vehicle) {                    //если метод вернет true значит клиент премиум
        int visit = entryQueue.getVisitorList().get(vehicle.getNumber());
        return visit >= Tariff.VISITS_FOR_PREMIUM_STATUS.getDescription();
    }

    private double calculateParkingCost(Duration duration, Vehicle vehicle) {  //тут считаем, сколько нужно заплатить в зависимости от статуса клиента, причем 5 секунд бесплатные становятся платные если их превысить
        parkedTime = duration;
        double cost;
        if (validatePremiumClient(vehicle)) {
            cost = duration.toSeconds() * Tariff.PREMIUM_CLIENT_TARIFF.getDescription();
            System.out.println("Рады были вас видеть " + vehicle.getNumber() + ", сумма к оплате " + cost);
            return cost;
        }
        cost = duration.toSeconds() * Tariff.NEW_CLIENT_TARIFF.getDescription();
        System.out.println("До свидания " + vehicle.getNumber() + ", сумма к оплате " + cost);
        return cost;
    }

    public synchronized boolean pay(Vehicle vehicle) {
        System.out.println("Машина " + vehicle.getNumber() + " оплатила парковку");
        return true;
    }
}

