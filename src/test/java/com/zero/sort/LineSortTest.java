package com.zero.sort;


import com.zero.algorithms.linear.sort.BucketSort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

@DisplayName("线性排序算法测试")
public class LineSortTest {

    private static final int length = 100;

    private final int[] array = new int[length];

    @BeforeEach
    public void beforeEach() {
        Random rand = new Random();

        for (int i = 0; i < length; i++) {
            // 随机生成 [1, 1000000] 的数据
            array[i] = rand.nextInt(length) + 1;
        }

    }

    @DisplayName("桶排序")
    @Test
    public void testBucketSort() {
        BucketSort bucketSort = new BucketSort();
        // 100 数据，10 个桶
        int[] sort = bucketSort.sort(array, 10);
        System.out.println(Arrays.toString(sort));
    }
}
