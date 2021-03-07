package com.momoko.leetcode.daily;

import java.util.Arrays;

/**
 * Created by momoko on 2021/3/4.
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 *
 * 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 * 输入：nums = [10,9,2,5,3,7,101,18]
 * 输出：4
 * 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
 * 输入：nums = [7,7,7,7,7,7,7]
 * 输出：1
 */
public class LengthOfLIS {
    public int lengthOfLIS(int[] nums) {
        /**
         * 注意，严格递增，则序列中必须是 > 而不能是 >=
         * 可以看出，选择以数组中哪个数作为子序列的结尾，得到的子序列的长度与以前面的数做结尾的最长子序列的长度有关
         * 若前面的数都小于这个数，则最长子序列的长度 = 前面最长子序列的长度 + 1
         * 若前面的数存在不小于这个数的，则最长子序列的长度保持上一次迭代的值
         */
        int[] dp = new int[nums.length];
        //初始时，以nums[i]结尾的子序列的长度都为1，即当前数本身
        Arrays.fill(dp,1);
        //遍历的同时找到最长的子序列长度
        int res = dp[0];
        for (int i = 1; i < nums.length; i++) {
            // 看以前的，比它小的，说明可以接在后面形成一个更长的子序列
            // int curMax = Integer.MIN_VALUE; 不能这样写，万一前面没有比自己小的，
            // 这个值就得不到更新
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]){
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}