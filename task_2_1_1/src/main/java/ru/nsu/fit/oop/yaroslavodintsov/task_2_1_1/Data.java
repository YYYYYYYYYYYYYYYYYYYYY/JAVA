package ru.nsu.fit.oop.yaroslavodintsov.task_2_1_1;

/**
 * statistics of the restaurant and data.
 */
public class Data {

    private int currentOrderId;
    private int numOfCompletedOrders;
    private int numOfPizzaChefs;
    private int numOfDeliveryWorkers;
    private int numOfPizzaChefsFinishedWork;
    private int numOfDeliveryWorkersFinishedWork;
    private boolean restaurantIsClosed;

    /**
     * Zeroes all the statistics and data.
     */
    public Data() {

        currentOrderId = 0;
        numOfCompletedOrders = 0;
        numOfPizzaChefsFinishedWork = 0;
        numOfDeliveryWorkersFinishedWork = 0;
        restaurantIsClosed = false;

    }


    public boolean isRestaurantClosed() {

        return restaurantIsClosed;

    }


    public boolean areAllOrdersCompleted() {

        return currentOrderId == numOfCompletedOrders;

    }


    public boolean areAllPizzaChefsFinishedWork() {

        return numOfPizzaChefs == numOfPizzaChefsFinishedWork;

    }


    public boolean areAllDeliveryWorkersFinishedWork() {

        return numOfDeliveryWorkers == numOfDeliveryWorkersFinishedWork;

    }


    public int getCurrentOrderId() {

        return currentOrderId;

    }

    void updateCurrentOrderId() {

        currentOrderId++;

    }

    void closeRestaurant() {

        restaurantIsClosed = true;

    }

    public void completeOrder() {

        numOfCompletedOrders++;

    }

    public void setNumOfPizzaChefs(int numOfPizzaChefs) {

        this.numOfPizzaChefs = numOfPizzaChefs;

    }

    public void setNumOfDeliveryWorkers(int numOfDeliveryWorkers) {

        this.numOfDeliveryWorkers = numOfDeliveryWorkers;

    }

    public void endShiftForPizzaChef() {

        numOfPizzaChefsFinishedWork++;

    }

    public void endShiftForDeliveryWorker() {

        numOfDeliveryWorkersFinishedWork++;

    }

}
