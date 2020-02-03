package ru.nsu.fit.oop.yaroslavodintsov.task_4_1;

public class Division extends Binary {

    public static final String symbol = "/";

    @Override
    public double execute() {
        if(getArgument(1) == 0)
            throw new ArithmeticException("Don't / 0");
        return getArgument(0) / getArgument(1);
    }
}
