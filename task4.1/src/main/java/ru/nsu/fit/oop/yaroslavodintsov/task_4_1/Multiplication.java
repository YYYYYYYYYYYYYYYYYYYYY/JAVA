package ru.nsu.fit.oop.yaroslavodintsov.task_4_1;

public class Multiplication extends Binary {

    public static final String symbol = "*";
    @Override
    public double execute() {
        return getArgument(0) * getArgument(1);
    }
}
