package com.zero.algorithms.linear.queue;

import java.lang.reflect.Array;

/**
 * 数组实现队列
 */
public class ArrayQueue<E> extends AbstractQueue<E> {
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

    /**
     * Creates an ArrayQueue with the given capacity
     *
     * @param capacity the capacity of this queue
     */
    public ArrayQueue(Class<E> type, int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException();
        }
        this.items = (E[]) Array.newInstance(type, capacity);
    }


    public int capacity() {
        return items.length;
    }

    @Override
    public E dequeue() {
        if (front == rear) {
            throw new IllegalStateException("Queue empty");
        }
        return items[front++];
    }

    @Override
    public boolean enqueue(E e) {
        if (isFull()) {
            throw new IllegalStateException("Queue empty");
        }
        // 队尾没有空间了,需要执行数据迁移
        if (rear == capacity()) {
            // 数据迁移
            if (rear - front >= 0)  {
                System.arraycopy(items, front, items, 0, rear - front);
            }
            // 调整 front 与 rear
            rear -= front;
            front = 0;
        }
        items[rear++] = e;
        return true;
    }

    @Override
    public boolean isFull() {
        return rear == capacity() && front == 0;
    }

    @Override
    public boolean isEmpty() {
        return front == rear;
    }
}
