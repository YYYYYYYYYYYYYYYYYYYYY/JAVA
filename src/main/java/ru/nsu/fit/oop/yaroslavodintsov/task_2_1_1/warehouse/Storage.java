package ru.nsu.fit.oop.yaroslavodintsov.task_2_1_1.warehouse;

import java.util.concurrent.TimeUnit;

public class Storage {

    private static QueueMy<Order> itemsInWarehouse;

    public Storage(int capacity) {

        itemsInWarehouse = new QueueMy<>(capacity, true);

    }

    public void putItemAwayInStorage(Order order) {

        try {

            itemsInWarehouse.put(order);

        }

        catch (InterruptedException e) {

            e.printStackTrace();

        }

    }

    public Order pickItemForDelivery(int milliseconds) throws InterruptedException {

        return itemsInWarehouse.poll(milliseconds, TimeUnit.MILLISECONDS);

    }

    public int numOfItemsInWarehouse() {

        return itemsInWarehouse.size();

    }

}
