package src.main.Week4_5.Project.Parking;

import src.main.Week4_5.Project.Vehicle.Vehicle;
import src.main.Week4_5.Project.Vehicle.VehicleType;

public class ParkingValidator {

    public synchronized boolean parkingValidate(Vehicle vehicle, ParkingPlace parkingPlace) {
        if (isValidForSingleCar(vehicle, parkingPlace)) {
            System.out.println("Ваша машина " + vehicle.getNumber() + " припаркована.");
            return true;
        }

        if (isValidForFirstCarOnTruckSpot(vehicle, parkingPlace)) {
            System.out.println("Ваша машина " + vehicle.getNumber() + " припаркована на грузовом месте.");
            return true;
        }

        if (isValidForSecondCarOnTruckSpot(vehicle, parkingPlace)) {
            System.out.println("Машина с номером " + vehicle.getNumber() + " припарковалась по соседству на грузовом месте.");
            return true;
        }

        System.out.println("Парковка невозможна для машины с номером " + vehicle.getNumber());
        return false;
    }

    private boolean isValidForSingleCar(Vehicle vehicle, ParkingPlace parkingPlace) {
        return vehicle.getType().equals(parkingPlace.parkingPlaceType) &&
                parkingPlace.getParkedCars().isEmpty();
    }

    private boolean isValidForFirstCarOnTruckSpot(Vehicle vehicle, ParkingPlace parkingPlace) {
        return vehicle.getType().equals(VehicleType.CAR) &&
                parkingPlace.parkingPlaceType.equals(VehicleType.TRUCK) &&
                parkingPlace.getParkedCars().isEmpty();
    }

    private boolean isValidForSecondCarOnTruckSpot(Vehicle vehicle, ParkingPlace parkingPlace) {
        return parkingPlace.getParkedCars().size() == 1 &&
                vehicle.getType().equals(VehicleType.CAR) &&
                parkingPlace.parkingPlaceType.equals(VehicleType.TRUCK) &&
                parkingPlace.getParkedCars().values().stream()
                        .allMatch(parked -> parked.getType().equals(VehicleType.CAR));
    }
}