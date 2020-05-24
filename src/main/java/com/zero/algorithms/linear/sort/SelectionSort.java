package com.zero.algorithms.linear.sort;

import java.util.Arrays;

/**
 * 选择排序:无论什么情况都是 时间复杂度都是 O(n²),空间复杂度 O(1)，不稳定排序算法。
 * 分两个区间，已排序区间和未排序区间，每次选择排序会从未排序区间找出最小的元素，
 * 将其放到已排序的末尾。这样每次通过找最小值数据交换达到最终效果。
 */
public class SelectionSort implements ComparisonSort {
    /**
     * 算法步骤：
     * 1.在未排序序列找到最小的元素，存放到已排序序列的起始位置。
     * 2.再从剩余未排序序列中寻找最小的元素，继续放到已排序末尾。
     * 3.重复第二步，直到所有元素均排序完成。
     * @param sourceArray 原始数据
     * @return
     */
    @Override
    public int[] sort(int[] sourceArray) {
        int length = sourceArray.length;
        int[] result = Arrays.copyOf(sourceArray, length);
        if (length <= 0) {
            return result;
        }
        // 一共需要 length - 1 轮比较
        for (int i = 0; i < length - 1; i++) {
            // 每轮需要比较的次数 length - i，找出最小元素下标
            int minIndex = i;
            for (int j = i + 1; j < length; j++) {
                if (result[j] < result[minIndex]) {
                    // 查出每次最小远元素下标
                    minIndex = j;
                }
            }
            // 将当前 i 位置的数据与最小值交换数据
            if (i != minIndex) {
                int temp = result[i];
                result[i] = result[minIndex];
                result[minIndex] = temp;
            }
        }
        return result;
    }
}
