package ru.nsu.fit.oop.yaroslavodintsov.task_4_1;

public class Logarithm extends Unary {

    public static final String symbol = "log";
    @Override
    public double execute() {
        return Math.log(getArgument(0));
    }
}
