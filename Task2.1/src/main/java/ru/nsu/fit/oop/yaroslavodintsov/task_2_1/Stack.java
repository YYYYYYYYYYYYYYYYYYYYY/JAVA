package ru.nsu.fit.oop.yaroslavodintsov.task_2_1;

import java.util.*;


/**
 * Tis Class implements the Stack.
 * It includes push, pop, size functions.
 *
 * @param <U> Some data type.
 */
public class Stack<U> implements Iterable<U> {
    private List<U> elems;

    //Builds empty Stack
    public Stack() {
        elems = new ArrayList<>();
    }


    public void push(U item) {
        elems.add(item);
    }


    public U pop() {
        if (elems.isEmpty()) { throw new NoSuchElementException("Stack is Empty"); }

        return elems.remove(elems.size() - 1);
    }


    public int size() {
        return elems.size();
    }

    /**
     * Returns an iterator over the stack.
     * The iterator iterates through the objects in the stack in LIFO order.
     */
    @Override
    public Iterator<U> iterator() {
        return new StackIterator<U>(size() - 1);
    }

    private class StackIterator<U> implements Iterator<U> {
        int currentIndex;

        public StackIterator(int index) {
            currentIndex = index;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("The requested operations is not supported");
        }

        @Override
        public boolean hasNext() {
            return currentIndex >= 0;
        }

        @Override
        public U next() {
            if (!hasNext()) { throw new NoSuchElementException("Stack underflow"); }


            return (U) elems.get(currentIndex--);
        }
    }
}