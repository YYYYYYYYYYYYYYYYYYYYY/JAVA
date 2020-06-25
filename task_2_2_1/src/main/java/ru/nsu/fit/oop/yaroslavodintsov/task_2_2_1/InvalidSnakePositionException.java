package ru.nsu.fit.oop.yaroslavodintsov.task_2_2_1;

public class InvalidSnakePositionException extends Exception {

    private static final long serialVersionUID = 1L;

    public InvalidSnakePositionException(String message) {
        super(message);
    }
}
