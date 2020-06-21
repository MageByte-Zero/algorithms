package com.zero.algorithms.linear.sort;

public interface LineSort {

    /**
     * 排序
     * @param sourceArray 原始数据
     * @param bucketNum 桶容量
     * @return
     */
    int[] sort(int[] sourceArray, int bucketSize);

}
