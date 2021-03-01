package com.momoko.dup_pointer;

/**
 * Created by momoko on 2021/3/1.
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 * <p>
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0。
 * <p>
 * 输入：target = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 */
public class MinSubArrayLen {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        int num = minSubArrayLen(11, nums);
        System.out.println(num);
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int len = Integer.MAX_VALUE;
        int sum = 0;
        int i, j;
        for (i = 0, j = 0; j < nums.length; ) {
            sum = sum + nums[j];
            while (sum >= target) {
                len = Math.min(j - i + 1, len);
                sum = sum - nums[i];
                i++;
            }
            j++;
        }
        if (sum >= target) {
            len = Math.min(j - i + 1, len);
        }
        return len == Integer.MAX_VALUE ? 0 : len;
    }
}