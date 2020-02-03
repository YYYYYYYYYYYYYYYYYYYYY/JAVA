package ru.nsu.fit.oop.yaroslavodintsov.task_4_1;

public class Sine extends Unary {

    public static final String symbol = "sin";
    @Override
    public double execute() {
        return Math.sin(getArgument(0));
    }
}
