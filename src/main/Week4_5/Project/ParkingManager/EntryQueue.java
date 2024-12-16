package src.main.Week4_5.Project.ParkingManager;

import src.main.Week4_5.Project.Vehicle.Vehicle;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;

public class EntryQueue {

    ConcurrentHashMap<String, Integer> visitorList = new ConcurrentHashMap<>();
    private final ConcurrentLinkedQueue<Vehicle> entryQueue = new ConcurrentLinkedQueue<>();
    private final int maxQueueSize;
    private int refusals = 0;

    public EntryQueue(int maxQueueSize) {
        this.maxQueueSize = maxQueueSize;
    }

    public boolean addToQueue(Vehicle vehicle) {
        if (entryQueue.size() >= maxQueueSize) {
            System.out.println("Машина не может встать в очередь, очередь переполнена!");
            refusals++;
            sleep();
            return false;
        }
        entryQueue.add(vehicle);
        System.out.println("Машина " + vehicle.getNumber() + " успешно встала в очередь на парковку!");
        sleep();
        return true;
    }

    private void sleep() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public ConcurrentHashMap<String, Integer> getVisitorList() {
        return visitorList;
    }

    public Vehicle getNextVehicle() {
        return entryQueue.poll(); // Извлекает первый элемент или null, если очередь пуста
    }

    public int getRefusals() {
        return refusals;
    }

    public void incrementRefusals() {
        refusals++;
    }

}
