package com.zero.algorithms.linear.sort;

/**
 * 桶排序：把数组 arr 划分为n个大小相同子区间（桶），每个子区间各自排序，最后合并
 */
public class BucketSort implements LineSort {

    private static final QuickSort quickSort = new QuickSort();

    @Override
    public int[] sort(int[] sourceArray, int bucketSize) {
        // 找出最大、最小值
        int minValue = sourceArray[0];
        int maxValue = sourceArray[1];
        for (int value : sourceArray) {
            minValue = Math.min(minValue, value);
            maxValue = Math.max(maxValue, value);
        }
        // 桶数量
        int bucketCount = (maxValue - minValue) / bucketSize + 1;
        int[][] buckets = new int[bucketCount][bucketSize];
        // 保存每个桶的数组的元素个数，默认值 0
        int[] indexArr = new int[bucketCount];

        // 将数组中值分配到各个桶里
        for (int value : sourceArray) {
            int bucketIndex = (value - minValue) / bucketSize;
            // 当前桶的数组达到最大值,需要拓容
            if (indexArr[bucketIndex] == buckets[bucketIndex].length) {
                ensureCapacity(buckets, bucketIndex);
            }
            // 将数据放到桶中，并且桶对应的容量 + 1
            buckets[bucketIndex][indexArr[bucketIndex]++] = value;
        }

        // 对每个桶进行排序，这里使用了快速排序
        int k = 0;
        for (int i = 0; i < buckets.length; i++) {
            if (indexArr[i] == 0) {
                continue;
            }
            // 默认容量是 bucketSize, 要根据实际桶的容量排序，否则不足 bucketSize 的默认值是 0
            quickSort.quickSortInternal(buckets[i], 0, indexArr[i] - 1);
            for (int j = 0; j < indexArr[i]; j++) {
                sourceArray[k++] = buckets[i][j];
            }
        }
        return sourceArray;
    }

    /**
     * 数组扩容,并保存数据
     *
     * @param buckets
     * @param bucketIndex
     */
    private void ensureCapacity(int[][] buckets, int bucketIndex) {
        int[] tempArr = buckets[bucketIndex];
        int[] newArr = new int[tempArr.length * 2];
        for (int j = 0; j < tempArr.length; j++) {
            newArr[j] = tempArr[j];
        }
        buckets[bucketIndex] = newArr;
    }

}
