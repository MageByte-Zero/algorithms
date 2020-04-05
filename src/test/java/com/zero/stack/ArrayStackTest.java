package com.zero.stack;

import com.zero.algorithms.linear.stack.ArrayStack;
import org.junit.jupiter.api.*;

@DisplayName("基于数组实现的栈测试")
public class ArrayStackTest {

    ArrayStack<Integer> arrayStack = new ArrayStack<>();

    @BeforeEach
    public void tearup() {
        System.out.println("当前测试方法开始");
        System.out.println(arrayStack.toString());
    }

    @AfterEach
    public void tearDown() {
        System.out.println("当前测试方法结束");
        System.out.println(arrayStack.toString());
    }

    @Test
    public void testPush() {
        arrayStack.push(1);
    }

    @Test
    public void testPop() {
        arrayStack.push(1);
        arrayStack.push(2);
        Integer pop = arrayStack.pop();
        Integer pop1 = arrayStack.pop();
        Integer pop2 = arrayStack.pop();
        Assertions.assertEquals(2, pop);
        Assertions.assertEquals(1, pop1);
        Assertions.assertNull(pop2);
    }

    @Test
    public void testClear() {
        arrayStack.push(0);
        arrayStack.push(1);
        arrayStack.push(2);
        arrayStack.push(3);
        arrayStack.clear();
    }

    @Test
    public void testExpand() {
        arrayStack = new ArrayStack<>(2, 3);
        for (int i = 0; i < 4 ; i++) {
            arrayStack.push(i);
        }
        System.out.println(arrayStack.toString());
    }

}
