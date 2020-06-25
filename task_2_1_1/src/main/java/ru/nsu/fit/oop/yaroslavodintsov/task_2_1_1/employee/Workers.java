package ru.nsu.fit.oop.yaroslavodintsov.task_2_1_1.employee;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Workers {

    @JsonProperty("Chefs")
    final ChefIt[] chefIts;

    @JsonProperty("deliveryGuys")
    final DeliveryGuy[] deliveryWorkers;

    Workers(
            @JsonProperty("Chefs") ChefIt[] chefIts,
            @JsonProperty("deliveryGuy") DeliveryGuy[] deliveryWorkers) {


        this.chefIts = chefIts;
        this.deliveryWorkers = deliveryWorkers;

    }

}
