package com.momoko.dup_pointer;

/**
 * Created by momoko on 2021/3/1.
 * 给定一个二进制数组， 计算其中最大连续 1 的个数。
 *
 * 输入：[1,1,0,1,1,1]
 * 输出：3
 * 解释：开头的两位和最后的三位都是连续 1 ，所以最大连续 1 的个数是 3.
 */
public class FindMaxConsecutiveOnes {

    public int findMaxConsecutiveOnes(int[] nums) {
        int maxLen = 0;
        int len = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                len++;
            } else {
                maxLen = Math.max(len, maxLen);
                len = 0;
            }
        }
        return Math.max(len, maxLen);
    }
}