package com.zero.algorithms.linear.sort;

import java.util.Arrays;

/**
 * 插入排序：时间复杂度 O(n²),平均时间复杂度 O(n²),最好时间复杂度 O(n)，
 * 最坏时间复杂度 O(n²),空间时间复杂度 O(1).稳定排序算法。
 */
public class InsertionSort implements ComparisonSort {
    /**
     * 算法步骤：
     * 1. 将第一待排序序列第一个元素看做一个有序序列，把第二个元素到最后一个元素当成是未排序序列。
     * 2.从头到尾依次扫描未排序序列，将扫描到的每个元素插入有序序列的适当位置。（如果待插入的元素与有序序列中的某个元素相等，则将待插入元素插入到相等元素的后面。）
     * @param sourceArray 原始数据
     * @return
     */
    @Override
    public int[] sort(int[] sourceArray) {
        int[] result = Arrays.copyOf(sourceArray, sourceArray.length);
        if (sourceArray.length <= 1) {
            return result;
        }
        // 从下标为 1 开始比较选择合适位置插入，因为下标 0 只有一个元素，默认是有序
        int length = result.length;
        for (int i = 1; i < length; i++) {
            // 待插入数据
            int insertValue = result[i];
            // 从已排序的序列最右边元素开始比较，找到比待插入树更小的数位置
            int j = i - 1;
            for (; j >= 0; j--){
                if (result[j] > insertValue) {
                    // 向后移动数据,腾出待插入位置
                    result[j + 1] = result[j];
                } else {
                    // 找到待插入位置，跳出循环
                    break;
                }
            }
            // 插入数据，因为前面多执行了 j--，
            result[j + 1] = insertValue;
        }
        return result;
    }
}
