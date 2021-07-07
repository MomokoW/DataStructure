package com.momoko.dp;

import javax.swing.plaf.metal.MetalTheme;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by momoko on 2021/6/23.
 * 求数组中最长递增子序列的个数
 * 交替打印两个数组
 */
public class MaxSubArrayNum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入数组:");
        String str = scanner.nextLine();
        // 将数组转为整型数组
        int[] nums = parseStrToArray(str);
        // 求最长递增子序列的个数
        int res = getMaxSubArrayNum(nums);
        System.out.println(res);
    }

    private static int getMaxSubArrayNum(int[] nums) {
        int N = nums.length;
        if (N == 0) {
            return 0;
        }
        // 表示以nums[i]结尾的LIS长度
        int[] dp = new int[N];
        // 表示以nums[i]结尾的LIS的组合的个数
        int[] dp_nums = new int[N];
        Arrays.fill(dp, 1);
        Arrays.fill(dp_nums, 1);
        int maxLen = dp[0];
        // (1)当dp[j]+1 > dp[i]时,意味着我们第一次找到这个组合
        // (2)当dp[j]+1 == dp[i]时,意味着我们不是第一次找到这个组合
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        dp_nums[i] = dp_nums[j];
                    } else if (dp[j] + 1 == dp[i]) {
                        dp_nums[i] += dp_nums[j];
                    }
                }
            }
            maxLen = Math.max(dp[i], maxLen);
        }
        int res = 0;
        for (int i = 0; i < N; i++) {
            if (dp[i] == maxLen) {
                res += dp_nums[i];
            }
        }
        return res;
    }

    private static int[] parseStrToArray(String str) {
        String[] strs = str.split(" ");
        int[] nums = new int[strs.length];
        for (int i = 0; i < strs.length; i++) {
            nums[i] = Integer.parseInt(strs[i]);
        }
        return nums;
    }


}
