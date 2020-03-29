package com.zero.linkedlist;

import com.zero.algorithms.linear.list.SingleLinkedList;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("单向链表测试")
public class SingleLinkedListTest {
    SingleLinkedList<Integer> singleLinkedList = new SingleLinkedList<>();

    @BeforeAll
    public static void init() {
    }

    @AfterAll
    public static void cleanup() {
    }

    @BeforeEach
    public void tearup() {
        System.out.println("当前测试方法开始");
        System.out.println(singleLinkedList.toString());
    }

    @AfterEach
    public void tearDown() {
        System.out.println("当前测试方法结束");
        System.out.println(singleLinkedList.toString());
    }

    @DisplayName("add 默认末尾添加")
    @Test
    void testAdd() {
        singleLinkedList.add(1);
        singleLinkedList.add(2);
    }

    @DisplayName("在指定位置添加 add")
    @Test
    void testAddIndex() {
        singleLinkedList.add(0, 1);
        singleLinkedList.add(0, 0);
    }

    @DisplayName("addFirst 表头添加测试")
    @Test
    void testAddFirst() {
        singleLinkedList.addFirst(0);
        singleLinkedList.addFirst(1);
    }

    @DisplayName("contains 测试")
    @ParameterizedTest
    @ValueSource(ints = {1})
    void testContains(int e) {
        singleLinkedList.add(e);
        boolean contains = singleLinkedList.contains(e);
        Assertions.assertTrue(contains);
    }

    @DisplayName("testIndexOf")
    @ParameterizedTest
    @ValueSource(ints = {3})
    void testIndexOf(int o) {
        singleLinkedList.add(1);
        singleLinkedList.add(2);
        singleLinkedList.add(3);
        int indexOf = singleLinkedList.indexOf(o);
        Assertions.assertEquals(2, indexOf);

    }

    @DisplayName("test Get")
    @Test
    void testGet() {
        singleLinkedList.addFirst(3);
        singleLinkedList.addFirst(2);
        singleLinkedList.addFirst(1);
        Integer result = singleLinkedList.get(1);
        Assertions.assertEquals(2, result);
    }

    @DisplayName("testRemoveObject 删除只有头结点")
    @Test
    void testRemoveObjectWithHead() {
        singleLinkedList.add(1);
        singleLinkedList.add(2);
        singleLinkedList.add(3);
        singleLinkedList.addFirst(0);
        singleLinkedList.remove(0);
        singleLinkedList.remove(Integer.valueOf(3));
        singleLinkedList.remove(Integer.valueOf(2));
        singleLinkedList.remove(Integer.valueOf(1));
    }

}
