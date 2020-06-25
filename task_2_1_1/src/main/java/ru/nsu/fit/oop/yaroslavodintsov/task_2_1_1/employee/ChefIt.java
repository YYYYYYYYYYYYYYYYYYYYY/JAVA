package ru.nsu.fit.oop.yaroslavodintsov.task_2_1_1.employee;

import com.fasterxml.jackson.annotation.JsonProperty;
import ru.nsu.fit.oop.yaroslavodintsov.task_2_1_1.*;
import ru.nsu.fit.oop.yaroslavodintsov.task_2_1_1.warehouse.Upcoming;
import ru.nsu.fit.oop.yaroslavodintsov.task_2_1_1.warehouse.Order;
import ru.nsu.fit.oop.yaroslavodintsov.task_2_1_1.warehouse.Storage;

public class ChefIt implements Runnable {

    @JsonProperty("id")
    private final int id;

    @JsonProperty("cookingTime")
    private final int cookingTime;

    private boolean waitingForOrder;

    private Storage storage;
    private Upcoming upcoming;
    private Data data;
    private Chefs chefs;

    ChefIt(@JsonProperty("id") int id, @JsonProperty("cookingTime") int cookingTime) {

        this.id = id;
        this.cookingTime = cookingTime;
        waitingForOrder = false;

    }

    public boolean isWaitingForOrder() {

        return waitingForOrder;

    }

    void setStorage(Storage storage) {

        this.storage = storage;

    }

    void setUpcoming(Upcoming upcoming) {

        this.upcoming = upcoming;

    }

    void setPizzaRestaurantHeadquarters(Data data) {

        this.data = data;

    }

    void setChefs(Chefs chefs) {

        this.chefs = chefs;
    }

    @Override
    public void run() {

        while (!data.isRestaurantClosed()
                || !upcoming.areThereNoOrders()) {

            Order currentOrder;

            try {
                this.waitingForOrder = true;
                chefs.lock.lock();
                if (data.isRestaurantClosed() && upcoming.areThereNoOrders()) {

                    break;

                }

                currentOrder = upcoming.takeOrder();
                this.waitingForOrder = false;
            } finally {

                chefs.lock.unlock();

            }

            System.out.println(
                    "CHEF          #" + id + " | MAKING ORDER #" + currentOrder.getId());

            System.out.println(
                    "CHEF          #"
                            + id
                            + " | FINISHED ORDER #"
                            + currentOrder.getId());
            System.out.println("CHEF          #" + id + " | STORED ORDER #" + currentOrder.getId());
            storage.putItemAwayInStorage(currentOrder);

        }

        data.endShiftForPizzaChef();
        System.out.println("CHEF          #" + id + " | ALL 4 TODAY");

    }

    int getId() {

        return id;

    }

    int getCookingTime() {

        return cookingTime;

    }
}
