package com.momoko.monotony_stack;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by momoko on 2021/3/6.
 */
public class NextGreaterElements {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,3};
    }
    public static int[] nextGreaterElements(int[] nums) {
        //先上暴力搜索
//        int n = nums.length;
//        int[] res = new int[n];
//        for (int i = 0; i < n; i++) {
//            int max = nums[i];
//            for (int j = (i + 1) % n; j != i; j = (j + 1) % n) {
//                if (nums[j] > nums[i]) {
//                    max = nums[j];
//                    break;
//                }
//            }
//            if (max == nums[i]) {
//                res[i] = -1;
//            } else {
//                res[i] = max;
//            }
//        }
//        return res;

        //使用单调栈维护每个下标对应的下一个最大值的位置
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < n * 2 - 1; i++) {
            while (!stack.isEmpty() && nums[i % n] > nums[stack.peek()]) {
                ans[stack.pop()] = nums[i % n];
            }
            stack.push(i % n);
        }
        return ans;
    }
}