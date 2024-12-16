package src.main.Week4_5.Project.Parking;

import src.main.Week4_5.Project.ParkingManager.EntryQueue;
import src.main.Week4_5.Project.PaymentSystem.PaymentSystem;
import src.main.Week4_5.Project.Vehicle.Vehicle;
import src.main.Week4_5.Project.Vehicle.VehicleType;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;


public class ParkingPlace {

    public VehicleType parkingPlaceType;
    public boolean isPaid;

    private ParkingValidator parkingValidator = new ParkingValidator();
    private PaymentSystem paymentSystem;
    private final ConcurrentHashMap<String, Vehicle> parkedCars = new ConcurrentHashMap<>();

    public ParkingPlace(VehicleType parkingPlaceType, EntryQueue entryQueue, PaymentSystem paymentSystem) {
        this.parkingPlaceType = parkingPlaceType;
        this.paymentSystem = paymentSystem;
        System.out.println("Парковочное место создано.");
    }

    public synchronized void parkCar(Vehicle vehicle) {
        validateAndPutCar(vehicle);
    }

    public synchronized Vehicle leaveThePlace(Vehicle vehicle) {
        validateAndPollParkedCar(vehicle);
        return vehicle;
    }

    private boolean validateAndPollParkedCar(Vehicle vehicle) {
        if (parkedCars.values().removeIf(car -> car.getNumber().equals(vehicle.getNumber()))) {
            paymentSystem.validateClient(vehicle);
            validateForPay(this, vehicle);
            isPaid = true;
            System.out.println("Машина " + vehicle.getNumber() + " отправилась к выезду с парковки");
            sleep();
            return true;
        }
        System.out.println("Не удалось выехать с парковки");
        return false;
    }

    private boolean validateAndPutCar(Vehicle vehicle) {
        if (parkingValidator.parkingValidate(vehicle, this)) {
            sleep();
            putCar(vehicle);
            setStartParkingTime(vehicle);
            return true;
        }
        System.out.println("Вашей машине не подходит это место");
        return false;
    }

    public void validateForPay(ParkingPlace parkingPlace, Vehicle vehicle) {
        if (parkingPlace.isPaid()) {
            return;
        }
        System.out.println("Похоже машина " + vehicle.getNumber() + " не оплатила парковку, ожидаем оплату");
        sleep();
        paymentSystem.pay(vehicle);
    }

    private void setStartParkingTime(Vehicle vehicle) {
        vehicle.setParkingTime();
    }


    private void putCar(Vehicle vehicle) {
        parkedCars.put(vehicle.getNumber(), vehicle);
    }


    public ConcurrentHashMap<String, Vehicle> getParkedCars() {
        return parkedCars;
    }

    private void sleep() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean isPaid() {
        return isPaid;
    }
}
