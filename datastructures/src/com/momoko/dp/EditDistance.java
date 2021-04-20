package com.momoko.dp;

/**
 * Created by momoko on 2021/3/23.
 * 给你两个单词 s 和 t，请你计算出将 s 转换成 t 所使用的最少操作数。
 *
 * 你可以对一个单词进行如下两种操作：
 *
 * 删除一个字符
 * 替换一个字符
 * 注意：
 *
 * 不允许插入操作
 * 题目保证有解
 *
 * 输入：s = "abcdefg", t = "abdde"
 * 输出：3
 */
public class EditDistance {
    public static void main(String[] args) {
        edit_distance("abcdefg", "abdde");
    }

    public static int edit_distance(String s, String t) {
        //求替换的最小次数，可定义状态转移方程
        //dp[i][j]表示将s的前j个元素替换成t的前i个元素的最小次数（只要包含就可以）
        int m = t.length();
        int n = s.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            int[] temp = new int[n + 1];
            temp[i] = dp[i - 1][i - 1] + (t.charAt(i - 1) == s.charAt(i - 1) ? 0 : 1);
            for (int j = i + 1; j <= n; j++) {
                if (t.charAt(i - 1) == s.charAt(j - 1)) {
                    temp[j] = dp[i - 1][j - 1];
                } else {
                    //包含替换或者不替换不相等的元素这两种情况
                    temp[j] = Math.min(dp[i - 1][j - 1] + 1, temp[j - 1]);
                }
            }
            dp[i] = temp;
        }
        return dp[m][n] + (n - m);
    }
}