package ru.nsu.fit.oop.yaroslavodintsov.task_2_1_1.employee;

import ru.nsu.fit.oop.yaroslavodintsov.task_2_1_1.Data;
import ru.nsu.fit.oop.yaroslavodintsov.task_2_1_1.warehouse.Storage;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Delivery {

    final Lock lock;
    private final List<Future<?>> orders;

    public Delivery() {

        orders = new ArrayList<>();
        lock = new ReentrantLock(true);

    }

    public void run(
            Workers workers,
            Storage storage,
            Data data) {

        data.setNumOfDeliveryWorkers(workers.deliveryWorkers.length);
        ExecutorService executor = Executors.newFixedThreadPool(workers.deliveryWorkers.length);

        for (DeliveryGuy deliveryGuy : workers.deliveryWorkers) {

            deliveryGuy.setDeliveryWorkers(this);
            deliveryGuy.setPizzaRestaurantHeadquarters(data);
            deliveryGuy.setStorage(storage);

            Future<?> future = executor.submit(deliveryGuy);
            orders.add(future);

        }
    }

    List<Future<?>> getOrders() {

        return orders;

    }
}
