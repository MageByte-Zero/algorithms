package com.zero.algorithms.linear.stack;

import java.util.Arrays;

/**
 * 基于数组实现的栈
 * @param <T>
 */
public class ArrayStack<T> {
    public static final int DEFAULT_SIZE = 128;
    private static final int DEFAULT_LIMIT = -1;
    /**
     * 初始化栈大小
     */
    private int size;
    /**
     * 栈最大限制数，-1 表示无限制
     */
    private final int limit;
    /**
     * 栈顶元素下标，默认没有数据 -1
     */
    private int index;
    /**
     * 保存数据
     */
    private Object[] stack;

    public ArrayStack() {
        this(DEFAULT_SIZE, DEFAULT_LIMIT);
    }

    public ArrayStack(int size, int limit) {
        this.index = -1;
        if (limit > DEFAULT_LIMIT && size > limit) {
            this.size = limit;
        } else {
            this.size = size;
        }
        this.limit = limit;
        this.stack = new Object[size];
    }

    /**
     * push obj to stack of top
     *
     * @param obj push data
     * @return true if push success
     */
    public boolean push(T obj) {
        index++;
        // 判断是否需要拓容
        if (index == size) {
            // 若超过限制则返回 false，否则执行拓容
            if (limit != DEFAULT_LIMIT && size >= limit) {
                index--;
                return false;
            } else {
                expand();
            }
        }
        stack[index] = obj;
        return true;
    }

    /**
     * pop stack of top element
     *
     * @return top of stack element
     */
    public T pop() {
        if (index == -1) {
            return null;
        }
        T result = (T) stack[this.index];
        stack[index--] = null;
        return result;
    }

    /**
     * 清空栈数据
     */
    public void clear() {
        // 判断是否空
        if (index > -1) {
            // 只需要将 index + 1 个元素设置 null，不需要遍历 size
            for (int i = 0; i < index + 1; i++) {
                stack[i] = null;
            }
        }
        index = -1;
    }

    public int size() {
        return this.index;
    }

    /**
     * 扩容两倍 ，若是两倍数值超过 limit 则只能拓容到 limit
     */
    private void expand() {
        int newSize = size * 2;
        if (limit != DEFAULT_LIMIT && newSize > limit) {
            newSize = limit;
        }
        Object[] newStack = new Object[newSize];
        System.arraycopy(stack, 0, newStack, 0, size);
        this.stack = newStack;
        this.size = newSize;
    }

    @Override
    public String toString() {
        return "ArrayStack{" +
                "size=" + size +
                ", limit=" + limit +
                ", index=" + index +
                ", stack=" + Arrays.toString(stack) +
                '}';
    }
}
