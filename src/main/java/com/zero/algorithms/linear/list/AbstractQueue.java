package com.zero.algorithms.linear.list;

/**
 * 队列抽象
 * @param <E>
 */
public abstract class AbstractQueue<E> implements Queue<E> {

    /**
     * Throws NullPointerException if argument is null.
     *
     * @param e the element
     */
    protected void checkNotNull(E e) {
        if (e == null) {
            throw new NullPointerException();
        }
    }

}
