package com.zero.queue;

import com.zero.algorithms.linear.list.ArrayCircleQueue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("循环数组队列测试")
public class ArrayCircleQueueTest {

    @DisplayName("出队与入队操作测试")
    @Test
    public void test() {
        ArrayCircleQueue<String> circleQueue = new ArrayCircleQueue<>(String.class, 8);
        System.out.println("circleQueue capacity = " + circleQueue.capacity());
        int i = 1;
        while (!circleQueue.isFull()) {
            circleQueue.enqueue("S" + (i++));
        }
        while (!circleQueue.isEmpty()) {
            System.out.println(circleQueue.dequeue());
        }
    }
}
