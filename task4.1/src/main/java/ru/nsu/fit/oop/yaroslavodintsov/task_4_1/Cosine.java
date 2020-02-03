package ru.nsu.fit.oop.yaroslavodintsov.task_4_1;

public class Cosine extends Unary {

    public static final String symbol = "cos";
    @Override
    public double execute() {
        return Math.cos(getArgument(0));
    }
}
