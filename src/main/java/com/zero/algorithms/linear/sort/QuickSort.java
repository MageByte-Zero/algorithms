package com.zero.algorithms.linear.sort;

import java.util.Arrays;

/**
 * 快速排序
 */
public class QuickSort implements ComparisonSort {
    @Override
    public int[] sort(int[] sourceArray) {
        // 对 arr 进行拷贝，不改变参数内容
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
        quickSortInternal(arr, 0, arr.length - 1);
        return arr;
    }

    /**
     * 快速排序
     * @param arr 数据
     * @param p 开始下标
     * @param r 结束下标
     * @return
     */
    private void quickSortInternal(int[] arr, int p, int r) {
        if (p >= r) {
            return;
        }
        // 获取分区点，也就是 pivot 下标
        int q = partition(arr, p, r);
        // 递归调用直到有序
        quickSortInternal(arr, p, q - 1);
        quickSortInternal(arr, q + 1, r);
    }

    /**
     * 分区函数：挖坑填洞，先把基准元素的坑挖出来，然后遍历坑后面的数组，比坑的位置小则交换数据
     * 。并标记最新的坑的位置
     * @param arr 待分区数据
     * @param p 开始下标
     * @param r 结束喜爱奥
     * @return
     */
    private int partition(int[] arr, int p, int r) {
        // 设置基准值，选择第一个，也可以随机,
        int pivot = arr[p];
        //从基准元素的下一个位置开始遍历数组，记录当前坑的位置，最后把 pivot 值放到这个坑中
        int index = p;

        for (int i = p + 1; i <= r; i++) {
            // 比基准数据小
            if (arr[i] < pivot) {
                // 坑位移动
                index++;
                // 交换数据 i 位置的 与 index 位置数据交换
                int indexValue = arr[index];
                arr[index] = arr[i];
                arr[i] = indexValue;
            }
        }
        // 最后把 pivot位置与 与 最后的坑 index 交换
        arr[p] = arr[index];
        arr[index] = pivot;
        return index;
    }
}
