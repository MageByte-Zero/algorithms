package com.zero.algorithms.linear.queue;

import com.zero.algorithms.linear.list.SingleLinkedList;

public class LinkedQueue<E> extends AbstractQueue<E> implements Queue<E> {

    private final SingleLinkedList<E> linkedList;

    public LinkedQueue() {
        this.linkedList = new SingleLinkedList<>();
    }

    @Override
    public E dequeue() {
        if (linkedList.isEmpty()) {
            throw new IllegalStateException("Queue empty");
        }
        return linkedList.remove();
    }

    @Override
    public boolean enqueue(E e) {
        return linkedList.add(e);
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }
}
