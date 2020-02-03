package ru.nsu.fit.oop.yaroslavodintsov.task_4_1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * This class implements custom Stack
 */
public class Stack<T> implements Iterable {

    private int maxSize = 0;
    private int top = -1;
    private T[] stackArray = null;

    public Iterator iterator() { return new StackIterator();}

    @SuppressWarnings("unchecked")
    public Stack(int size) {
        this.maxSize = size;
        this.stackArray = (T[]) new Object[size];
    }


    public boolean push (T elem) {
        if(!isFull()) {
            stackArray[++top] = elem;
            return true;
        }
        else {
            throw new StackSizeLimitException("Stack is full!");
        }
    }


    public T pop() {
        if(!isEmpty()) {
            T result = this.stackArray[top];
            this.stackArray[top] = null;
            this.top--;
            return result;
        }
        else {
            throw new StackSizeLimitException("Stack is empty!");
        }
    }


    public boolean isEmpty() {
        return (top == -1);
    }


    public boolean isFull() {
        return (top == maxSize - 1);
    }

    @SuppressWarnings("unchecked")
    public void clear() {
        this.top = -1;
        this.stackArray = (T[]) new Object[maxSize];
    }


    public int count() {
        return top + 1;
    }

    private class StackIterator implements Iterator {

        public boolean hasNext() { return top != -1; }

        public T next() {
            if(!hasNext()) throw new NoSuchElementException();
            return stackArray[top--];
        }
    }
}

class StackSizeLimitException
        extends RuntimeException {
    StackSizeLimitException(String errorMessage) {
        super(errorMessage);
    }
}