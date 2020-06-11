package ru.nsu.fit.oop.yaroslavodintsov.task_2_2_1;

public enum Direction {

    NORTH, EAST, SOUTH, WEST;

    private Direction opposite;

    static {
        NORTH.opposite = SOUTH;
        SOUTH.opposite = NORTH;
        EAST.opposite = WEST;
        WEST.opposite = EAST;
    }

    public Direction getOppositeDirection() {
        return opposite;
    }

}
