package src.main.Week4_5.Project.ParkingManager;

import src.main.Week4_5.Project.Vehicle.Vehicle;

import java.util.concurrent.ConcurrentLinkedQueue;

public class ExitQueue {

    private final ConcurrentLinkedQueue<Vehicle> exitQueue = new ConcurrentLinkedQueue<>();

    public boolean addToQueue(Vehicle vehicle) {
        exitQueue.add(vehicle);
        System.out.println("Машина " + vehicle.getNumber() + " успешно встала в очередь на выезд с парковки!");
        return true;
    }

    public Vehicle leave() {
        return exitQueue.poll();
    }
}
