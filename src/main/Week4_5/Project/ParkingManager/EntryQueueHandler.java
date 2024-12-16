package src.main.Week4_5.Project.ParkingManager;

import src.main.Week4_5.Project.Parking.ParkingPlace;
import src.main.Week4_5.Project.Parking.ParkingPlaceBase;
import src.main.Week4_5.Project.PaymentSystem.Tariff;
import src.main.Week4_5.Project.Vehicle.Vehicle;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

public class EntryQueueHandler implements QueueHandler {

    private ParkingPlaceBase parkingPlaceBase;
    private EntryQueue entryQueue;

    public EntryQueueHandler(ParkingPlaceBase parkingPlaceBase, EntryQueue entryQueue) {
        this.parkingPlaceBase = parkingPlaceBase;
        this.entryQueue = entryQueue;
    }

    @Override
    public void processQueue() {
        Optional<ParkingPlace> parkingPlace = parkingPlaceBase.getParkingPlace();
        if (parkingPlace.isPresent()) {                                         // Успешно получили парковочное место
            Vehicle vehicle = entryQueue.getNextVehicle();
            if (vehicle != null) {
                parkingPlace.get().parkCar(vehicle);                            // Припарковали машину
                parkingPlaceBase.addParkingPLaces(parkingPlace.get());          // Вернули место в базу
                return;
            }
            parkingPlaceBase.addParkingPLaces(parkingPlace.get());              // Если нет машины, место нужно вернуть в любом случае
        } else {
            System.out.println("Не удалось выехать из очереди на въезд");
        }
        sleep();
    }

    private void sleep() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void addVisitorList(Vehicle vehicle) {
        if (entryQueue.visitorList.containsKey(vehicle.getNumber())) {   //если ключ есть в коллекции то прибавляем 1
            int currentValue = entryQueue.visitorList.get(vehicle.getNumber());
            System.out.println("Машина " + vehicle.getNumber() + " не первый раз на парковке еще " + (Tariff.VISITS_FOR_PREMIUM_STATUS.getDescription() - currentValue) +" парковок и получите скидку");
            entryQueue.visitorList.put(vehicle.getNumber(), currentValue + 1);
        } else {
            entryQueue.visitorList.put(vehicle.getNumber(), 1);
        }
    }
}
