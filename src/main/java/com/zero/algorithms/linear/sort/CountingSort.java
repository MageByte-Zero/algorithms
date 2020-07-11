package com.zero.algorithms.linear.sort;

/**
 * 公众号：码哥字节
 * 计数排序
 */
public class CountingSort {
    public int[] sort(int[] sourceArray) {
        if (sourceArray == null || sourceArray.length <= 1) {
            return new int[0];
        }
        // 1.查找数列最大值,最小值
        int max = sourceArray[0];
        int min = sourceArray[0];
        for (int value : sourceArray) {
            max = Math.max(max, value);
            min = Math.min(min, value);
        }
        int d = max - min;
        // 2.根据数据最大值确定统计数组长度
        int[] countArray = new int[d + 1];
        // 3. 遍历原始数组映射到统计数组中,统计元素的个数
        for (int value : sourceArray) {
            countArray[value - min]++;
        }
        // 4.统计数组变形，后面的元素等于前面元素之和。目的是定位在结果数组中的排位
        for (int i = 1; i < countArray.length; i++) {
            countArray[i] += countArray[i - 1];
        }
        // 5.倒序遍历原始数组，从统计数组查找对应的正确位置，输出到结果表
        int[] sortedArray = new int[sourceArray.length];
        for (int i = sourceArray.length - 1; i >= 0; i--) {
            int value = sourceArray[i];
            // 分数在 countArray 中的排名, - 1 则是结果数组的下标
            int index = countArray[value - min] - 1;
            sortedArray[index] = value;
            countArray[value - min]--;
        }
        return sortedArray;
    }
}
