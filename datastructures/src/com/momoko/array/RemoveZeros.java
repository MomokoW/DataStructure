package com.momoko.array;

import java.util.Arrays;

/**
 * Created by momoko on 2021/3/2.
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 */
public class RemoveZeros {
    public static void main(String[] args) {
        int[] nums = {1,0,1,0,3,12,0};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void moveZeroes(int[] nums) {
        //双指针，一个指针永远指在零元素上，然后另一个指针进行移动找到非零元素，然后进行交换
        for (int i = 0, j = 0; j < nums.length; j++) {
            if (nums[j] != 0) {
                //交换两个元素的位置
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
            }
        }
    }
}