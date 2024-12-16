package src.main.Week4_5.Project;

import src.main.Week4_5.Project.Parking.ParkingPlaceBase;
import src.main.Week4_5.Project.ParkingManager.AccessControlSystem;
import src.main.Week4_5.Project.ParkingManager.EntryQueue;
import src.main.Week4_5.Project.ParkingManager.ExitQueue;
import src.main.Week4_5.Project.PaymentSystem.Discount;
import src.main.Week4_5.Project.PaymentSystem.PaymentSystem;
import src.main.Week4_5.Project.Vehicle.Vehicle;
import src.main.Week4_5.Project.Vehicle.VehicleBase;

import java.util.Optional;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        EntryQueue entryQueue = new EntryQueue(4);
        ExitQueue exitQueue = new ExitQueue();
        Discount discount = new Discount();
        PaymentSystem paymentSystem = new PaymentSystem(entryQueue);
        VehicleBase vehicleBase = new VehicleBase();
        ParkingPlaceBase parkingPlaceBase = new ParkingPlaceBase();
        AccessControlSystem accessControlSystem = new AccessControlSystem(entryQueue, exitQueue, paymentSystem, discount, parkingPlaceBase, vehicleBase);
        VehicleAndPlaceGenerator VehicleAndPlaceGenerator = new VehicleAndPlaceGenerator();

        VehicleAndPlaceGenerator.generateVehicles(vehicleBase, entryQueue, 5);
        VehicleAndPlaceGenerator.generateParkingPlaces(parkingPlaceBase, 5, entryQueue, paymentSystem);
        System.out.println("----------------------------------\n \n");
        ExecutorService service = Executors.newFixedThreadPool(5);
        accessControlSystem.startProcessing();

        while (true) {
            Main.sleep();
            Optional<Vehicle> optionalVehicle = vehicleBase.getVehicle();
            if (optionalVehicle.isPresent()) {
                Vehicle vehicle = optionalVehicle.get();
                service.submit(() -> {
                    try {
                        vehicle.run();  // Запускаем машину в отдельном потоке
                    } catch (Exception e) {
                        System.out.println("Ошибка при обработке машины: " + vehicle.getNumber());
                    }
                });
            } else {
                System.out.println("Очередь пуста");
                Main.sleep();
            }
        }
    }

    static private void sleep() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}


