package src.main.Week4_5.Project.ParkingManager;

import src.main.Week4_5.Project.Parking.ParkingPlace;
import src.main.Week4_5.Project.Parking.ParkingPlaceBase;
import src.main.Week4_5.Project.PaymentSystem.PaymentSystem;
import src.main.Week4_5.Project.Vehicle.Vehicle;
import src.main.Week4_5.Project.Vehicle.VehicleBase;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

public class ExitQueueHandler implements QueueHandler {

    private ParkingPlaceBase parkingPlaceBase;
    private ExitQueue exitQueue;
    private VehicleBase vehicleBase;
    private PaymentSystem paymentSystem;

    public ExitQueueHandler(ParkingPlaceBase parkingPlaceBase, ExitQueue exitQueue, VehicleBase vehicleBase, PaymentSystem paymentSystem) {
        this.parkingPlaceBase = parkingPlaceBase;
        this.exitQueue = exitQueue;
        this.vehicleBase = vehicleBase;
    }

    @Override
    public void processQueue() {
        Optional<ParkingPlace> parkingPlace = parkingPlaceBase.getParkingPlace();
        if (parkingPlace.isPresent()) {                                            // успешно получили место
            for (Vehicle vehicle : parkingPlace.get().getParkedCars().values()) {//не знаем сколько точно машин, поэтому пройдемся циклом
                exitQueue.addToQueue(parkingPlace.get().leaveThePlace(vehicle));//выезжаем
                sleep();
                comebackVehicleBase(exitQueue.leave());
                sleep();
            }
            parkingPlaceBase.addParkingPLaces(parkingPlace.get());                 //обязательно возвращаем парковочное место в базу(в конец очереди)
            sleep();
        } else {
            System.out.println("Не удалось получить парковочное место из базы при выезде");
            sleep();
        }
    }

    public void comebackVehicleBase(Vehicle vehicle) {
        if (vehicle != null) {
            System.out.println("Машина " + vehicle.getNumber() + " возвращается в базу.");
            vehicleBase.addVehicle(vehicle);
        } else {
            System.out.println("Нет машин в очереди на выезд.");
        }
    }

    private void sleep() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
