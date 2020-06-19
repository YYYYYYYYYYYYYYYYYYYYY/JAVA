package ru.nsu.fit.oop.yaroslavodintsov.task_2_1_1.employee;

import ru.nsu.fit.oop.yaroslavodintsov.task_2_1_1.FutureMy;
import ru.nsu.fit.oop.yaroslavodintsov.task_2_1_1.warehouse.Upcoming;
import ru.nsu.fit.oop.yaroslavodintsov.task_2_1_1.Data;
import ru.nsu.fit.oop.yaroslavodintsov.task_2_1_1.warehouse.Storage;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Chefs {
    final Lock lock;
    private final List<FutureMy> pizzaChefsWithTheirPizzas;

    public Chefs() {

        this.pizzaChefsWithTheirPizzas = new ArrayList<>();
        lock = new ReentrantLock(true);

    }

    public void run(
            Workers workers,
            Storage storage,
            Upcoming upcoming,
            Data data) {

        data.setNumOfPizzaChefs(workers.chefIts.length);
        ExecutorService executorService = Executors.newFixedThreadPool(workers.chefIts.length);

        for (ChefIt chefIt : workers.chefIts) {

            chefIt.setChefs(this);
            chefIt.setPizzaRestaurantHeadquarters(data);
            chefIt.setStorage(storage);
            chefIt.setUpcoming(upcoming);

            pizzaChefsWithTheirPizzas.add(
                    new FutureMy(chefIt, executorService.submit(chefIt)));

        }

    }

    public List<FutureMy> getPizzaChefsWithTheirPizzas() {

        return pizzaChefsWithTheirPizzas;

    }
}
