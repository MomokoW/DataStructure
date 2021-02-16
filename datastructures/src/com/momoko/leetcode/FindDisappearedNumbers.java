package com.momoko.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;

/**
 * Created by momoko on 2021/2/13.
 */

/**
 * 给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。
 *
 * 找到所有在 [1, n] 范围之间没有出现在数组中的数字。
 *
 * 您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。
 */
public class FindDisappearedNumbers {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int max = Arrays.stream(nums).max().orElse(0);
        int min = Arrays.stream(nums).min().orElse(0);
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        if (min > 1) {
            for (int i = 1; i < min; i++) {
                list.add(i);
            }
        }
        if (max < nums.length) {
            for (int i = max + 1; i < nums.length; i++) {
                list.add(i);
            }
        }
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] - nums[i] != 0 || nums[i + 1] - nums[i] != 1 ) {
                for (int j = nums[i] + 1; j < nums[i + 1]; j++) {
                    list.add(j);
                }
            }

        }
        return list;
    }
}