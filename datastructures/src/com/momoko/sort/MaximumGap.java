package com.momoko.sort;

import java.util.Arrays;

import javax.management.StandardEmitterMBean;

/**
 * Created by momoko on 2021/3/13.
 * 给定一个无序的数组，找出数组在排序之后，相邻元素之间最大的差值。
 *
 * 如果数组元素个数小于 2，则返回 0。
 */
public class MaximumGap {

    public int maximumGap(int[] nums) {
         if (nums.length < 2) {
             return 0;
         }
         int len = nums.length;
        // //找出最大值和最小值
        //先使用sort来进行排序，然后进行一次遍历得到

        Arrays.sort(nums);
        //遍历得到相邻数之间的gap
        int maxGap = 0;
        for (int i = 0, j = 1; j < len; i++, j++) {
            int temp = nums[j] - nums[i];
            if (temp > maxGap) {
                maxGap = temp;
            }
        }
        return maxGap;

    }
}