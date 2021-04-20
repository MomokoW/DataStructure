package com.momoko.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by momoko on 2021/4/16.
 * 题目：给定一个数组，要找到这个数组里面每个元素右边比我大的元素的位置
 * - 注意：是右边第一个比我大的，如果有多个的话
 * - 如果没有，那么用-1表示。
 * 返回：一个数组，表示右边比我大的数的下标位置
 *
 * 输入：[5, 6]
 * 输出：[1, -1]
 * 解释：A[0] = 5，右边比我大的是A[1] = 6, 所以记录为 = 1
 *       A[1] = 6, 右边比我大的元素没有，所以记录为   = -1
 *       所以返回值是[1, -1]
 */
public class RightFirstMax {
    // 用递减栈
    public static int[] findRightLarge(int[] A) {
        if (A == null || A.length == 0) {
            return new int[0];
        }
        // 结果数组
        int[] ans = new int[A.length];
        // 递减栈，保存的是数组元素的索引
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < A.length; i++) {
            int x = A[i];
            // 每个元素都向左遍历栈中的元素完成消除动作
            // 这里是递减栈
            // 如果发现进来的元素x与栈中元素相比
            // 如果大于栈中的元素，那么要把栈中的元素弹出去
            while (!stack.isEmpty() && A[stack.peek()] < x) {
                ans[stack.pop()] = i;
            }
            // 符合递减栈的元素的下标入栈
            stack.push(i);
        }
        // 栈中剩下的元素右边都不存在比它大的元素了
        while (!stack.isEmpty()) {
            ans[stack.pop()] = -1;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1,4,5,6,9,2,3,10};
        int[] ans = findRightLarge(arr);
        System.out.println(Arrays.toString(ans));
    }
}