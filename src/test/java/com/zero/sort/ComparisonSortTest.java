package com.zero.sort;

import com.zero.algorithms.linear.sort.BubbleSort;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

@DisplayName("比较排序算法测试")
public class ComparisonSortTest {

    @DisplayName("冒泡排序")
    @Test
    public void testBubbleSort() {
        BubbleSort bubbleSort = new BubbleSort();
        int[] array = {3, 5, 4, 1, 2, 6};
        int[] sort = bubbleSort.sort(array);
        System.out.println(Arrays.toString(sort));

    }
}
