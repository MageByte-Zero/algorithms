package com.zero.queue;

import com.zero.algorithms.linear.list.LinkedQueue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("链表实现队列测试")
public class LinkedQueueTest {

    @DisplayName("出队与入队操作测试")
    @Test
    public void test() {
        LinkedQueue<Integer> linkedQueue = new LinkedQueue<>();
        for (int i = 0; i < 4; i++) {
            linkedQueue.enqueue(i);
        }
        for (int i = 0; i < 4 ; i++) {
            System.out.println(linkedQueue.dequeue());
        }
    }
}
