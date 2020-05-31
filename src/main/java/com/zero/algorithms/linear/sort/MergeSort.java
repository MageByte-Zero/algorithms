package com.zero.algorithms.linear.sort;

import com.sun.istack.internal.NotNull;

import java.util.Arrays;

/**
 * 归并排序：时间复杂度 O(nlogn),平均时间复杂度 O(nlogn),最好时间复杂度 O(nlogn)，
 * 空间时间复杂度 O(n).稳定排序算法。
 */
public class MergeSort implements ComparisonSort {
    @Override
    public int[] sort(int[] sourceArray) {
        // copy sourceArray，不改变参数内容
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
        int length = arr.length;
        // 递归终止条件
        if (length < 2) {
            return arr;
        }
        // 将大任务拆分子任务
        int middle = length / 2;
        int[] left = Arrays.copyOfRange(arr, 0, middle);
        int[] right = Arrays.copyOfRange(arr, middle, length);
        // 递归调用，合并子任务
        return merge(sort(left), sort(right));
    }

    /**
     * 合并数据
     *
     * @param left  左边序列
     * @param right 右边序列
     * @return
     */
    private int[] merge(@NotNull int[] left, @NotNull int[] right) {
        int[] result = new int[left.length + right.length];
        int i = 0;
        // 谁小谁在前面
        while (left.length > 0 && right.length > 0) {
            if (left[0] <= right[0]) {
                result[i++] = left[0];
                left = Arrays.copyOfRange(left, 1, left.length);
            } else {
                result[i++] = right[0];
                right = Arrays.copyOfRange(right, 1, right.length);
            }
        }
        // 以下两个只有一个会执行
        while (left.length > 0) {
            result[i++] = left[0];
            left = Arrays.copyOfRange(left, 1, left.length);
        }

        while (right.length > 0) {
            result[i++] = right[0];
            right = Arrays.copyOfRange(right, 1, right.length);
        }

        return result;
    }
}
