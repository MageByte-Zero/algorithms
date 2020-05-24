package com.zero.sort;

import com.zero.algorithms.linear.sort.BubbleSort;
import com.zero.algorithms.linear.sort.InsertionSort;
import com.zero.algorithms.linear.sort.SelectionSort;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

@DisplayName("比较排序算法测试")
public class ComparisonSortTest {

    @DisplayName("冒泡排序")
    @Test
    public void testBubbleSort() {
        BubbleSort bubbleSort = new BubbleSort();
        int[] array = {3, 5, 4, 2, 1, 6};
        int[] sort = bubbleSort.sort(array);
        System.out.println(Arrays.toString(sort));

    }

    @DisplayName("插入排序")
    @Test
    public void testInsertSort() {
        InsertionSort insertionSort = new InsertionSort();
        int[] array = {3, 5, 4, 2, 1, 6, 5};
        int[] sort = insertionSort.sort(array);
        System.out.println(Arrays.toString(sort));
    }

    @DisplayName("选择排序")
    @Test
    public void testSelectSort() {
        SelectionSort selectionSort = new SelectionSort();
        int[] array = {3, 5, 4, 2, 1, 6, 5};
        int[] sort = selectionSort.sort(array);
        System.out.println(Arrays.toString(sort));
    }
}
