package inteview.concurrent.shopee;

/**
 * Created by momoko on 2021/8/2.
 *
 * 将整数n分成k份，且每份不能为空，任意两种分法不能相同(不考虑顺序)。
 *
 * 例如: n = 7, k = 3, 下面三种分法被认为是相同的：
 *
 * 1, 1, 5; 1, 5, 1; 5, 1, 1。
 *
 * 问有多少种不同的分法。
 *
 * 输入: n, k (6 < n < 200, 1 < k < 7)
 *
 * 输出: 一个整数 (所有可能的分法总数)
 */
public class DivideNum {

    /**
     * Note: 类名、方法名、参数名已经指定，请勿修改
     *
     *
     *
     * @param n int整型 整数n
     * @param k int整型 分为k份
     * @return int整型
     */
    public int divide(int n, int k) {
        // 每个整数n只分一份只有一种分法，分成n份也只有一种分法
        // dp[i][j]表示整数i被分为j份的分法，dp[i][j] = dp[i-1][j-1] + dp[i-j][j];
        int[][] dp = new int[n + 1][k + 1];
        // 初始化dp数组
        for (int i = 1; i <= n; i++) {
            dp[i][1] = 1;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = 2; j <= k; j++) {
                if (i > j) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - j][j];
                } else {
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }
        return dp[n][k];
    }
}
