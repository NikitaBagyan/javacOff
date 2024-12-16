package src.main.Week4_5.Project.ParkingManager;

import src.main.Week4_5.Project.Parking.ParkingPlaceBase;
import src.main.Week4_5.Project.PaymentSystem.Discount;
import src.main.Week4_5.Project.PaymentSystem.PaymentSystem;
import src.main.Week4_5.Project.Vehicle.VehicleBase;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AccessControlSystem {

    private final EntryQueue entryQueue;
    private final ExitQueue exitQueue;
    private final PaymentSystem paymentSystem;
    private final Discount discount;
    private final ParkingPlaceBase parkingPlaceBase;
    private final VehicleBase vehicleBase;
    private final List<QueueHandler> queueHandlers = new ArrayList<>();
    private final ExecutorService executorService = Executors.newFixedThreadPool(2); //тут magic number потому что я так и не продумал реализацию через size() чтобы это выглядело нормлаьно

    public AccessControlSystem(EntryQueue entryQueue, ExitQueue exitQueue, PaymentSystem paymentSystem, Discount discount, ParkingPlaceBase parkingPlaceBase, VehicleBase vehicleBase) {
        this.entryQueue = entryQueue;
        this.exitQueue = exitQueue;
        this.paymentSystem = paymentSystem;
        this.discount = discount;
        this.parkingPlaceBase = parkingPlaceBase;
        this.vehicleBase = vehicleBase;
        EntryQueueHandler entryQueueHandler = new EntryQueueHandler(parkingPlaceBase, entryQueue);
        ExitQueueHandler exitQueueHandler = new ExitQueueHandler(parkingPlaceBase, exitQueue, vehicleBase, paymentSystem);
        addHandler(entryQueueHandler);
        addHandler(exitQueueHandler);
    }

    private void addHandler(QueueHandler queueHandler) {
        queueHandlers.add(queueHandler);
    }

    public void startProcessing() {
        for (QueueHandler queueHandler : queueHandlers) {
            executorService.submit(() -> {
                while (true) {
                    queueHandler.processQueue();
                    Thread.sleep(1000);
                }
            });
        }
    }
}


