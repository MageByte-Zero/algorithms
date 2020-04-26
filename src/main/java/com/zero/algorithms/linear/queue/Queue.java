package com.zero.algorithms.linear.queue;

public interface Queue<E> {
    /**
     * 队头元素出队
     * @return
     */
    E dequeue();

    /**
     * 元素队尾入队
     * @param e 元素
     * @return true if add last success
     */
    boolean enqueue(E e);

    /**
     * 队列是否满了
     * @return
     */
    boolean isFull();

    /**
     * 队列是否是空的
     * @return
     */
    boolean isEmpty();
}
