package com.zero.algorithms.linear.queue;

import java.lang.reflect.Array;

/**
 * 数组实现环形队列
 *
 * @param <E>
 */
public class ArrayCircleQueue<E> extends AbstractQueue<E> {

    /**
     * The queued items
     */
    final E[] items;
    /**
     * 队头指针
     */
    private int front;

    /**
     * 队尾指针
     */
    private int rear;

    public int capacity() {
        return items.length;
    }

    /**
     * Creates an ArrayQueue with the given capacity
     *
     * @param capacity the capacity of this queue
     */
    public ArrayCircleQueue(Class<E> type, int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException();
        }
        this.items = (E[]) Array.newInstance(type, capacity);
    }

    @Override
    public E dequeue() {
        if (front == rear) {
            throw new IllegalStateException("Queue empty");
        }
        E item = items[front];
        front = (front + 1) % items.length;
        return item;
    }

    @Override
    public boolean enqueue(E e) {
        checkNotNull(e);
        int newRear = (rear + 1) % items.length;
        if (newRear == front) {
            throw new IllegalStateException("Queue full");
        }
        items[rear] = e;
        this.rear = newRear;
        return true;
    }

    @Override
    public boolean isFull() {
        return (rear + 1) % items.length == front;
    }

    @Override
    public boolean isEmpty() {
        return rear == front;
    }
}
