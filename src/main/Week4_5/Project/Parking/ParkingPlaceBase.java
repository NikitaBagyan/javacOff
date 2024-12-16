package src.main.Week4_5.Project.Parking;

import java.util.Optional;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ParkingPlaceBase {

    private ConcurrentLinkedQueue<ParkingPlace> parkingPlaces = new ConcurrentLinkedQueue<>();

    public synchronized void addParkingPLaces(ParkingPlace parkingPlace) {          //Добавляем место в конец очереди
        parkingPlaces.offer(parkingPlace);
    }

    public synchronized Optional<ParkingPlace> getParkingPlace() {                  //Получаем первое парковочное место
        if (parkingPlaces.isEmpty()) {
            System.out.println("Не удалось получить парковочное место из базы");
            return Optional.empty();
        } else {
            return Optional.ofNullable(parkingPlaces.poll());
        }
    }
}
