package com.momoko.dp;

/**
 * Created by momoko on 2021/3/18.
 * 给定一个字符串 s 和一个字符串 t ，计算在 s 的子序列中 t 出现的个数。
 *
 * 字符串的一个 子序列 是指，通过删除一些（也可以不删除）字符且不干扰剩余字符相对位置所组成的新字符串。（例如，"ACE" 是 "ABCDE" 的一个子序列，而 "AEC" 不是）
 *
 * 题目数据保证答案符合 32 位带符号整数范围。
 */
public class NumDistinct {
    public static void main(String[] args) {
        numDistinct("rabbbit", "rabbit");
    }

    public static int numDistinct(String s, String t) {
        int m = s.length(), n = t.length();
        int[] dp = new int[n + 1];
        for (int i = 1; i <= m; i++) {
            int pre = 1;
            for (int j = 1; j <= n; j++) {
                int cur = dp[j];
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[j] += pre;
                }
                pre = cur;
            }
        }
        return dp[n];
    }
}