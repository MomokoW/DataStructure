package com.momoko.sort;

import java.util.Arrays;

/**
 * Created by momoko on 2021/2/14.
 * 冒泡排序
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {3, 9, -1, 10, -2};

        int temp = 0;
        boolean flag = false;  //标识变量，表示是否进行过交换，如果一趟下来都未进行交换，则直接停止循环
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            if (!flag) {
                break;
            } else {
                flag = false;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}