package ru.nsu.fit.oop.yaroslavodintsov.task_2_1_1;

import ru.nsu.fit.oop.yaroslavodintsov.task_2_1_1.employee.*;
import ru.nsu.fit.oop.yaroslavodintsov.task_2_1_1.warehouse.Upcoming;
import ru.nsu.fit.oop.yaroslavodintsov.task_2_1_1.warehouse.Order;
import ru.nsu.fit.oop.yaroslavodintsov.task_2_1_1.warehouse.Storage;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;


public class PizzaHutJava {

    private final Workers workers;
    private final Data data;
    private final Upcoming upcoming;
    private final Storage storage;
    private final Chefs chefs;
    private final Delivery deliveryWorkers;
    private static final int WAITING_TIME_MILLISECONDS = 3000;

    private static final List<String> PIZZA_SIZES =
            new ArrayList<>(Arrays.asList("small", "medium", "large", "extra-large"));

    private static final List<String> PIZZAS =
            new ArrayList<>(
                    Arrays.asList(
                            "Coronapizza",
                            "Margherita",
                            "Mexicano",
                            "BBQ",
                            "Winner Winner",
                            "Chicken dinner",
                            "Pepperoni",
                            "Black lives matter"));



    public PizzaHutJava(File employeesParameters, int warehouseCapacity) {

        JSONReader reader = new JSONReader();
        workers = reader.readParameters(employeesParameters);
        data = new Data();
        storage = new Storage(warehouseCapacity);
        upcoming = new Upcoming();
        chefs = new Chefs();
        deliveryWorkers = new Delivery();

    }


    public Data start(int numOfOrders) {

        chefs.run(workers, storage, upcoming, data);
        deliveryWorkers.run(workers, storage, data);

        IntStream.range(0, numOfOrders).forEach(i -> order());
        closeRestaurant();

        return data;

    }

    private void order() {

        Random random = new Random();
        System.out.println(
                "ORDER #"
                        + data.getCurrentOrderId()
                        + " "
                        + PIZZA_SIZES.get(random.nextInt(PIZZA_SIZES.size()))
                        + " "
                        + PIZZAS.get(random.nextInt(PIZZAS.size()))
                        + ".");

        Order order = new Order(data.getCurrentOrderId());
        data.updateCurrentOrderId();
        upcoming.order(order);

    }

    private void closeRestaurant() {

        data.closeRestaurant();

        while (!upcoming.areThereNoOrders()) {

            try {

                Thread.sleep(WAITING_TIME_MILLISECONDS);

            }

            catch (InterruptedException e) {

                e.printStackTrace();

            }

        }

        for (FutureMy getPizzaChefsWithTheirPizzas :
                chefs.getPizzaChefsWithTheirPizzas()) {

            ChefIt chefIt = (ChefIt) getPizzaChefsWithTheirPizzas.object;

            if (chefIt.isWaitingForOrder()) {

                getPizzaChefsWithTheirPizzas.future.cancel(true);

            }

        }

        while (!data.areAllPizzaChefsFinishedWork()
                || !data.areAllDeliveryWorkersFinishedWork()) {

            try {

                Thread.sleep(WAITING_TIME_MILLISECONDS);

            }

            catch (InterruptedException e) {

                e.printStackTrace();

            }

        }

    }

}
