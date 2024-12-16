package src.main.Week4_5.Project.Vehicle;

import java.util.Optional;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;

public class VehicleBase {

    private ConcurrentLinkedQueue<Vehicle> vehicles = new ConcurrentLinkedQueue<>();

    public synchronized void addVehicle(Vehicle vehicle) {
        System.out.println("Машина " + vehicle + " появилась в базе");
        vehicles.offer(vehicle);
        sleep();
    }

    public synchronized Optional<Vehicle> getVehicle() {
        if (vehicles.isEmpty()) {
            System.out.println("Не удалось получить машину из базы");
            return Optional.empty();

        } else {
            return Optional.ofNullable(vehicles.poll());
        }
    }

    private void sleep() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
