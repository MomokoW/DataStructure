package com.momoko.sort;

import java.util.Arrays;

/**
 * Created by momoko on 2021/2/14.
 */
public class SelectionSort {
    public static void SelectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int index = i;
            int min = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                    index = j;
                }
            }
            //交换index与i位置的值
            if (index != i) {
                int temp = arr[i];
                arr[i] = arr[index];
                arr[index] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 9, -1, 10, -2};
        SelectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}