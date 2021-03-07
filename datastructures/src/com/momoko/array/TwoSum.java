package com.momoko.array;

import java.util.Arrays;

/**
 * Created by momoko on 2021/2/28.
 * 给定一个已按照 升序排列  的整数数组 numbers ，请你从数组中找出两个数满足相加之和等于目标数 target 。
 * <p>
 * 函数应该以长度为 2 的整数数组的形式返回这两个数的下标值。numbers 的下标 从 1 开始计数 ，所以答案数组应当满足 1 <= answer[0] < answer[1] <= numbers.length 。
 * <p>
 * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 * 输入：numbers = [2,7,11,15], target = 9
 * 输出：[1,2]
 * 解释：2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {3,24,50,79,88,150,345};
        int[] ints = twoSum(nums, 200);
        System.out.println(Arrays.toString(ints));


    }

    //注意返回的下标是从1开始计数的
    public static int[] twoSum(int[] numbers, int target) {
        int len = numbers.length;
        int left = 0, right = len - 1;
        while (left < right) {
            if (numbers[left] + numbers[right] == target) {
                return new int[]{left + 1, right + 1};
            } else if (numbers[left] + numbers[right] > target) {
                right--;
            } else {
                left++;
            }
        }
        return new int[]{-1, -1};
    }
}