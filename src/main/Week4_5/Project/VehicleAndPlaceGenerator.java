package src.main.Week4_5.Project;

import src.main.Week4_5.Project.Parking.ParkingPlace;
import src.main.Week4_5.Project.Parking.ParkingPlaceBase;
import src.main.Week4_5.Project.ParkingManager.EntryQueue;
import src.main.Week4_5.Project.PaymentSystem.PaymentSystem;
import src.main.Week4_5.Project.Vehicle.Vehicle;
import src.main.Week4_5.Project.Vehicle.VehicleBase;
import src.main.Week4_5.Project.Vehicle.VehicleType;

import java.util.Random;
import java.util.UUID;

public class VehicleAndPlaceGenerator {

    private final Random random = new Random();

    private Vehicle generateVehicle(EntryQueue entryQueue) {
        VehicleType type = random.nextBoolean() ? VehicleType.CAR : VehicleType.TRUCK;
        String number = UUID.randomUUID().toString().substring(0, 5).toUpperCase();
        return new Vehicle(type, number, entryQueue);
    }

    private ParkingPlace generateParkingPlace(EntryQueue entryQueue, PaymentSystem paymentSystem) {
        VehicleType type = random.nextBoolean() ? VehicleType.CAR : VehicleType.TRUCK;
        return new ParkingPlace(type, entryQueue, paymentSystem);
    }

    public void generateParkingPlaces(ParkingPlaceBase parkingPlaceBase, int count, EntryQueue entryQueue, PaymentSystem paymentSystem) {
        for (int i = 0; i < count; i++) {
            ParkingPlace place = generateParkingPlace(entryQueue, paymentSystem);
            parkingPlaceBase.addParkingPLaces(place);
            System.out.println("Создано парковочное место: " + place.parkingPlaceType);
        }
    }

    public void generateVehicles(VehicleBase vehicleBase, EntryQueue entryQueue, int count) {
        for (int i = 0; i < count; i++) {
            Vehicle vehicle = generateVehicle(entryQueue);
            vehicleBase.addVehicle(vehicle);
            System.out.println("Создана машина: " + vehicle);
        }
    }
}


