package ru.nsu.fit.oop.yaroslavodintsov.task_4_1;

public class UnaryMinus extends Unary {

    public static final String symbol = "~";
    @Override
    public double execute() {
        return -getArgument(0);
    }

}
