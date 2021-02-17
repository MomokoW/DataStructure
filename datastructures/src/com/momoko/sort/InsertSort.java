package com.momoko.sort;

import java.util.Arrays;

/**
 * Created by momoko on 2021/2/16.
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {101, 34, 119, 1};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int insertValue = arr[i];
            int insertIndex = i - 1;
            while (insertIndex >= 0 && insertValue < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            //判断需不需要进行赋值，优化
            if (insertIndex != i - 1) {
                arr[insertIndex + 1] = insertValue;
            }
        }
    }
}