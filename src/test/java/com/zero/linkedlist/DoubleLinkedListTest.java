package com.zero.linkedlist;

import com.zero.algorithms.linear.list.DoubleLinkedList;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("双向链表测试")
public class DoubleLinkedListTest {
    DoubleLinkedList<Integer> doubleLinkedList = new DoubleLinkedList<>();

    @BeforeAll
    public static void init() {
    }

    @AfterAll
    public static void cleanup() {
    }

    @BeforeEach
    public void tearup() {
        System.out.println("当前测试方法开始");
        System.out.println(doubleLinkedList.toString());
    }

    @AfterEach
    public void tearDown() {
        System.out.println("当前测试方法结束");
        System.out.println(doubleLinkedList.toString());
    }

    @DisplayName("add 默认末尾添加")
    @Test
    void testAdd() {
        doubleLinkedList.add(1);
        doubleLinkedList.add(2);
    }

    @DisplayName("在指定位置添加 add")
    @Test
    void testAddIndex() {
        doubleLinkedList.add(0, 1);
        doubleLinkedList.add(0, 2);
        doubleLinkedList.add(0, 3);
        doubleLinkedList.add(3, 4);
        doubleLinkedList.add(1, 99);
    }

    @DisplayName("addFirst 表头添加测试")
    @Test
    void testAddFirst() {
        doubleLinkedList.addFirst(0);
        doubleLinkedList.addFirst(1);
    }

    @DisplayName("contains 测试")
    @ParameterizedTest
    @ValueSource(ints = {1})
    void testContains(int e) {
        doubleLinkedList.add(e);
        boolean contains = doubleLinkedList.contains(e);
        Assertions.assertTrue(contains);
    }

    @DisplayName("testIndexOf")
    @ParameterizedTest
    @ValueSource(ints = {3})
    void testIndexOf(int o) {
        doubleLinkedList.add(1);
        doubleLinkedList.add(2);
        doubleLinkedList.add(3);
        int indexOf = doubleLinkedList.indexOf(o);
        Assertions.assertEquals(2, indexOf);

    }

    @DisplayName("test Get")
    @Test
    void testGet() {
        doubleLinkedList.addFirst(3);
        doubleLinkedList.addFirst(2);
        doubleLinkedList.addFirst(1);
        Integer result = doubleLinkedList.get(1);
        Assertions.assertEquals(2, result);
    }

    @DisplayName("testRemoveObject 删除")
    @Test
    void testRemoveObject() {
        doubleLinkedList.add(1);
        doubleLinkedList.add(2);
        doubleLinkedList.add(3);
        doubleLinkedList.addFirst(0);
        doubleLinkedList.remove(0);
        doubleLinkedList.remove(Integer.valueOf(3));
        doubleLinkedList.remove(Integer.valueOf(2));
        doubleLinkedList.remove(Integer.valueOf(1));
    }

}
