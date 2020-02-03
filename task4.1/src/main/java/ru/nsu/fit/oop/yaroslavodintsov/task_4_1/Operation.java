package ru.nsu.fit.oop.yaroslavodintsov.task_4_1;


/**
 *
 * Class for operations
 * Arity - number of arguments in function
 * Cnt - count of args
 */
public abstract class Operation {
    public final int arity;
    private int cnt;
    private double[] arguments;

    Operation(int arity) {
        this.cnt = 0;
        this.arity = arity;
        this.arguments = new double[arity];
    }

    /**
     *
     * Store input argument for future use
     */
    public void setArgument(double argument) {
        arguments[cnt++] = argument;
    }

    /**
     *
     * Get arguments
     */
    public double getArgument(int id) {
        return arguments[id];
    }

    /**
     *
     * Check if current number of arguments satisfies arity of function
     */
    public boolean readyToCalculate() {
        return arity == cnt;
    }

    /**
     *
     * Prepare the object for next calc
     */
    public void reset() {
        this.cnt = 0;
    }

    /**
     *
     * Abstract method which should be implemented in child classes
     */
    public abstract double execute();
}
