package com.momoko.sort;

import java.util.Arrays;

/**
 * Created by momoko on 2021/5/17.
 */
public class MergeSort {
    public static void mergeSort(int[] nums) {
        // 如果传进来的数组为空
        if (nums == null || nums.length == 0) {
            return;
        }
        // t是一个临时中转的数组
        int[] t = new int[nums.length];
        msort(nums, 0, nums.length, t);
    }

    private static void msort(int[] nums, int b, int e, int[] t) {
        // 空区间或者只有一个元素
        if (b == e || b + 1 >= e) {
            return;
        }
        // 分成两半，计算左右子数组
        int m = b + ((e - b) >> 1);
        // 将数组细分成最后只有一个元素的时候
        msort(nums, b, m, t);
        msort(nums, m, e, t);
        // 将数组进行合并
        // i指向左子数组的开头，j指向右子数组的开头
        // to指向临时数组与区间[b, e)对应的位置
        int i = b;
        int j = m;
        int to = b;
        // 判断条件是，只要两个子数组中还有元素
        while (i < m || j < e) {
            // 如果右子数组没有元素 或 左子数组开头的元素小于右子数组开头的元素
            // 那么取走左子数组开头的元素
            // nums[i] <= nums[j]这样可以保证合并排序是稳定的
            if ( j >= e || i < m && nums[i] <= nums[j]) {
                t[to++] = nums[i++];
            } else {
                // 否则取右子数组开头的元素
                t[to++] = nums[j++];
            }
        }
        // 把合并的结果拷回原来的数组nums，注意这里是左闭右开的
        for (i = b; i < e; i++) {
            nums[i] = t[i];
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 5, 3, 6, 23, 17, 12};
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}