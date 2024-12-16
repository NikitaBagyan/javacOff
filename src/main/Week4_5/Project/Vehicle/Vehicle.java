package src.main.Week4_5.Project.Vehicle;

import src.main.Week4_5.Project.ParkingManager.EntryQueue;

import java.time.Instant;

/**
 * Класс машины
 */

public class Vehicle implements Runnable {

    private VehicleType vehicleType;
    private String number;
    private Instant parkingTime;
    private EntryQueue entryQueue;


    public Vehicle(VehicleType vehicleType, String number, EntryQueue entryQueue) {
        this.vehicleType = vehicleType;
        this.number = number;
        this.entryQueue = entryQueue;
    }

    public VehicleType getType() {
        return vehicleType;
    }

    public String getNumber() {
        return number;
    }

    public void setParkingTime() {
        this.parkingTime = Instant.ofEpochMilli(System.currentTimeMillis());
    }

    public Instant getStartParkingTime() {
        return parkingTime;
    }

    private void moveToEntryQueue() {
        entryQueue.addToQueue(this);
    }

    @Override
    public void run() {
        try {
            moveToEntryQueue();
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Произошла поломка машины " + number);
            Thread.interrupted();
        }
    }

    @Override
    public String toString() {
        return "Машина {" +
                "Тип: " + (vehicleType == VehicleType.CAR ? "Легковая" : "Грузовая") +
                ", Номер: '" + number + '\'' +
                '}';
    }
}
