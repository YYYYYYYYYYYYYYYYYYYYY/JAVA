package ru.nsu.fit.oop.yaroslavodintsov.task_4_1;

public class Power extends Binary {

    public static final String symbol = "^";
    @Override
    public double execute() {
        return Math.pow(getArgument(0), getArgument(1));
    }
}
