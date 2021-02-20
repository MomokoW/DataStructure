package com.momoko.leetcode;

/**
 * Created by momoko on 2021/2/18.
 * 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 */
public class RemoveDuplicates {
    public static int removeDuplicates(int[] nums) {
        int count = 0;
        if (nums.length == 1) {
            return 1;
        }
        for (int i = 0, j = 1; j < nums.length;j++) {
            if (nums[i] != nums[j]) {
                count++;
                nums[count] = nums[j];
                i = j;
            }
        }
        //最后一个元素没有计算在内
        count++;
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        int num = removeDuplicates(nums);
        System.out.println(num);
    }
}