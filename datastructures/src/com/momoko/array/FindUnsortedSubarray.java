package com.momoko.array;

/**
 * Created by momoko on 2021/8/4.
 * 给你一个整数数组 nums ，你需要找出一个 连续子数组 ，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
 *
 * 请你找出符合题意的 最短 子数组，并输出它的长度。
 */
public class FindUnsortedSubarray {

    public static int findUnsortedSubarray(int[] nums) {
        // 双指针找左边和右边第一个不按顺序的元素的下标
        int N = nums.length;
        int start = 0, end = N - 1, max = nums[0], min = nums[N - 1];
        for (int i = 0; i < N; i++) {
            // 找到从右边开始第一个不按升序排列的数字
            max = Math.max(nums[i], max);
            // 找到从左边开始第一个不按升序排列的数字
            min = Math.min(nums[N - 1 - i], min);
            if (nums[i] < max) {
                start = i;
            }
            if (nums[N - 1 - i] > min) {
                end = N - 1 - i;
            }
        }
        return start > end ? start - end + 1 : 0;

    }

    public static void main(String[] args) {
        int[] nums = {2,6,4,8,10,9,15};
        int len = findUnsortedSubarray(nums);
    }
}
