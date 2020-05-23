package com.zero.algorithms.linear.sort;

import java.util.Arrays;

/**
 * 冒泡排序: 时间复杂度 O(n²)，最坏时间复杂度 O(n²)，最好时间复杂度 O(n)，平均时间复杂度 O(n²)
 * 空间复杂度 O(1)
 */
public class BubbleSort implements ComparisonSort {
    @Override
    public int[] sort(int[] sourceArray) {
        // 复制数组，不改变参数内容
        int[] result = Arrays.copyOf(sourceArray, sourceArray.length);
        if (sourceArray.length <= 1) {
            return result;
        }
        int length = result.length;
        for (int i = 0; i < length; i++) {
            // 设定标记，当没有数据需要交换的时候则说明已经有序，提前退出外部循环
            boolean hasChange = false;
            for (int j = 0; j < (length - 1) - i ; j++) {
                if (result[j] > result[j + 1]) {
                    // 数据交换
                    int temp = result[j];
                    result[j] = result[j + 1];
                    result[j + 1] = temp;
                    hasChange = true;
                }
            }
            if (!hasChange) {
                // 没有数据交换，已经有序,提前退出
                break;
            }
        }
        return result;
    }
}
