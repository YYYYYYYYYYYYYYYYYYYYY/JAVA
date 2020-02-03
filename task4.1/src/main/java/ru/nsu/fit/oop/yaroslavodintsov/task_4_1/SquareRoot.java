package ru.nsu.fit.oop.yaroslavodintsov.task_4_1;

public class SquareRoot extends Unary {

    public static final String symbol = "sqrt";
    @Override
    public double execute() {
        return Math.sqrt(getArgument(0));
    }
}
