package ru.nsu.fit.oop.yaroslavodintsov.task_2_1_1;

import java.util.concurrent.Future;

public class FutureMy {

    final Object object;
    final Future<?> future;

    public FutureMy(Object object, Future<?> future) {

        this.object = object;
        this.future = future;

    }

}
