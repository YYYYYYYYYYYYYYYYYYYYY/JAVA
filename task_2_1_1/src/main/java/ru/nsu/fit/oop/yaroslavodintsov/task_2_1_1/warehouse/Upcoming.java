package ru.nsu.fit.oop.yaroslavodintsov.task_2_1_1.warehouse;

import java.util.concurrent.LinkedBlockingQueue;

public class Upcoming {

    private final LinkedBlockingQueue<Order> pendingOrders;

    public Upcoming() {

        pendingOrders = new LinkedBlockingQueue<>();

    }

    public void order(Order order) {

        try {

            pendingOrders.put(order);

        }

        catch (InterruptedException e) {

            e.printStackTrace();

        }

    }

    public Order takeOrder() {

        try {

            return pendingOrders.take();

        }

        catch (InterruptedException e) {

            e.printStackTrace();

        }

        return null;

    }

    public boolean areThereNoOrders() {

        return pendingOrders.isEmpty();

    }

}

