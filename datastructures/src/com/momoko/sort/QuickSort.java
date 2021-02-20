package com.momoko.sort;

import java.util.Arrays;

/**
 * Created by momoko on 2021/2/18.
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {-9,78,0,23,-56,70};
        quickSort(arr,0,arr.length - 1);
        System.out.println(Arrays.toString(arr));

    }
    public static void quickSort(int[] arr, int left, int right) {
        int l = left;    //左下标
        int r = right;   //右下标
        int pivot = arr[(left + right) / 2];  //中轴值
        int temp = 0;
        //while循环的目的是让比pivot小的放到左边，大的放到右边
        while (l < r) {
            //在pivot左边一直找，找到大于等于pivot的值，才退出
            while (arr[l] < pivot) {
                l++;
            }
            //在pivot右边一直找，找到小于等于pivot的值，才退出
            while (arr[r] > pivot) {
                r--;
            }
            //如果l >= r说明pivot左右两边已经是左边小于pivot，右边大于pivot
            if (l >= r) {
                break;
            }
            //交换这两个值
            temp = arr[r];
            arr[r] = arr[l];
            arr[l] = temp;
            //交换完后，指针移动，这一步是为了防止数组中有相同的数造成死循环
            //及时更新数组的元素值
            if (arr[l] == pivot) {
                r--;
            }
            if (arr[r] == pivot) {
                l++;
            }
        }
        //如果l==r,必须l++，r--，否则会出现栈溢出
        if (l == r) {
            l++;
            r--;
        }
        //向左递归
        if (left < r) {
            quickSort(arr, left, r);
        }

        //向右递归
        if (right > l) {
            quickSort(arr, l, right);
        }
    }
}