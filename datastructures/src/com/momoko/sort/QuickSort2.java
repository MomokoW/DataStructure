package com.momoko.sort;

import java.util.Arrays;

/**
 * Created by momoko on 2021/3/2.
 */
public class QuickSort2 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,2,5,6};
        quickSort(arr, 0 , arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    /*
    对arr[i]..arr[j]中的记录进行一趟排序，将它们分成两部分
    使：[…这部分的值<=x…] x […这部分的值>=x…]
    用到了双指针的思想
     */
    public static int Partition(int arr[], int i, int j) {
        //用子表的第一个记录作为界点
        int temp = arr[i];  //保存界点的值
        int x = arr[i];
        while (i < j) {     //从表的两端交替地向中间扫描
            while (i < j && arr[j] >= x)
                j--;        //将比界点记录小的记录交换到低端
            arr[i] = arr[j];
            while (i < j && arr[i] <= x) {
                i++;        //将比界点记录大的记录交换到高端
            }
            arr[j] = arr[i];
        }
        arr[i] = temp;
        return i;          //返回界点所在位置
    }
    public static void quickSort(int arr[], int low, int high) {
        //对记录序列r[low]..r[high]进行快速排序
        if (low < high) {
            int k = Partition(arr, low, high); //将arr[low]..arr[high]分解为两部分
            quickSort(arr, low, k - 1);
            quickSort(arr, k + 1, high);
        }
    }
}