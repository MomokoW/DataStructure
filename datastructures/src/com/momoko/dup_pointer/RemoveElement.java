package com.momoko.dup_pointer;

/**
 * Created by momoko on 2021/3/1.
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 *
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 */
public class RemoveElement {
    public static void main(String[] args) {
        int[] nums = {4,5};
        int len = removeElement(nums, 4);
        for (int i = 0; i < len; i++) {
            System.out.println(nums[i]);
        }

    }
    public static int removeElement(int[] nums, int val) {
        if (nums.length == 0) {
            return 0;
        }
        //左边指针指向总是指向等于目标元素的数，右边指针总是指向第一个不等于目标元素的数
        int left = 0, right = nums.length - 1;
        while (left < right) {
            while (nums[left] != val && left < nums.length - 1)
                left++;
            while (nums[right] == val && right > 0) right--;

            if (left < right) {
                //将右边的值赋值到左边
                nums[left] = nums[right];
                //注意两个指针同时移动
                left++;
                right--;
            }
        }
        //判断，左右指针相等时的指向的那个数是否为目标元素
        if (nums[right] == val) {
            return right;
        }
        return right + 1;
    }

}