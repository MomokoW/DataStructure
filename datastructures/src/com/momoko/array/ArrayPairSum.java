package com.momoko.array;

import java.util.Arrays;

/**
 * Created by momoko on 2021/2/28.
 * 给定长度为 2n 的整数数组 nums ，你的任务是将这些数分成 n 对, 例如 (a1, b1), (a2, b2), ..., (an, bn) ，使得从 1 到 n 的 min(ai, bi) 总和最大。
 *
 * 返回该 最大总和 。
 */
public class ArrayPairSum {
    public static void main(String[] args) {
        int[] nums = {6,2,6,5,1,2};
        int sum = arrayPairSum(nums);
        System.out.println(sum);
    }
    //思路，先将数组排序，然后再按照排序后的数组跳着相加，就是最大的最小值
    public static int arrayPairSum(int[] nums) {
        //对数组进行排序
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i];
        }
        return sum;
    }
}