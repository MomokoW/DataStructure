package com.momoko.leetcode;

/**
 * Created by momoko on 2021/2/11.
 */

import java.util.Arrays;

/**
 * 设计一个找到数据流中第 k 大元素的类（class）。注意是排序后的第 k 大元素，不是第 k 个不同的元素。
 *
 * 请实现 KthLargest 类：
 *
 * KthLargest(int k, int[] nums) 使用整数 k 和整数流 nums 初始化对象。
 * int add(int val) 将 val 插入数据流 nums 后，返回当前数据流中第 k 大的元素。
 * 输入：
 * ["KthLargest", "add", "add", "add", "add", "add"]
 * [[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]
 * 输出：
 * [null, 4, 5, 5, 8, 8]
 *
 * 解释：
 * KthLargest kthLargest = new KthLargest(3, [4, 5, 8, 2]);
 * kthLargest.add(3);   // return 4
 * kthLargest.add(5);   // return 5
 * kthLargest.add(10);  // return 5
 * kthLargest.add(9);   // return 8
 * kthLargest.add(4);   // return 8
 */
public class KthLargest {

    int pos = 0;
    int[] array;
    int len;
    public KthLargest(int k, int[] nums) {
        len = nums.length + 1;
        array = Arrays.copyOf(nums, nums.length);
        pos = k;
        Arrays.sort(array);
    }

    public int add(int val) {
        int[] temp = new int[len];
        for (int i = 0; i < array.length; i++) {
            temp[i] = array[i];
        }
        temp[len - 1] = val;
        Arrays.sort(temp);
        return temp[pos - 1];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4, 5, 8, 2};
        KthLargest obj = new KthLargest(3, nums);
//        int num1 = obj.add(3);// return 4
//        System.out.println(num1);
//        int num2 = obj.add(5);// return 5
//        System.out.println(num2);
//        int num3 = obj.add(10);// return 5
//        System.out.println(num3);
        int num4 = obj.add(9);// return 8
        System.out.println(num4);
        int num5 = obj.add(4);// return 8
        System.out.println(num5);

    }
}