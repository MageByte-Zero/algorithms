package com.zero.sort;

import com.zero.algorithms.linear.sort.BubbleSort;
import com.zero.algorithms.linear.sort.InsertionSort;
import com.zero.algorithms.linear.sort.MergeSort;
import com.zero.algorithms.linear.sort.SelectionSort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

@DisplayName("比较排序算法测试")
public class ComparisonSortTest {

    private int[] array;

    @BeforeEach
    public void beforeEach() {
        this.array = new int[]{3, 5, 4, 2, 1, 6, 5, 2};
    }

    @DisplayName("冒泡排序")
    @Test
    public void testBubbleSort() {
        BubbleSort bubbleSort = new BubbleSort();
        int[] sort = bubbleSort.sort(array);
        System.out.println(Arrays.toString(sort));

    }

    @DisplayName("插入排序")
    @Test
    public void testInsertSort() {
        InsertionSort insertionSort = new InsertionSort();
        int[] sort = insertionSort.sort(array);
        System.out.println(Arrays.toString(sort));
    }

    @DisplayName("选择排序")
    @Test
    public void testSelectSort() {
        SelectionSort selectionSort = new SelectionSort();
        int[] sort = selectionSort.sort(array);
        System.out.println(Arrays.toString(sort));
    }

    @DisplayName("归并排序")
    @Test
    public void testMergeSort() {
        MergeSort mergeSort = new MergeSort();
        int[] sort = mergeSort.sort(array);
        System.out.println(Arrays.toString(sort));
    }
}
