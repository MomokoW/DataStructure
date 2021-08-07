package com.momoko.sort;

import java.util.Arrays;

/**
 * Created by momoko on 2021/8/7.
 * 计数排序，通过计数将元素放到对应的位置上来进行排序
 */
public class CountingSort {

    public static void main(String[] args) {
        int[] arr = {5,4,2,8,3,7,2,8,3,4,6,6,7,4,5,6};
        int maxValue = getMaxValue(arr);
        int[] res = countingSort(arr, maxValue);
        System.out.println(Arrays.toString(res));
    }


    public static int[] countingSort(int[] arr, int maxValue) {
        // 先创建计数的桶
        int bucketLen = maxValue + 1;
        int[] bucket = new int[bucketLen];
        for (int value : arr) {
            bucket[value]++;
        }
        int sortedIndex = 0;
        for (int i = 0; i < bucketLen; i++) {
            while (bucket[i] > 0) {
                arr[sortedIndex++] = i;
                bucket[i]--;
            }
        }
        return arr;
    }

    private static int getMaxValue(int[] arr) {
        int maxValue = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > maxValue) {
                maxValue = arr[i];
            }
        }
        return maxValue;
    }
}
