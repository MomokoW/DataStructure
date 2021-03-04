package com.momoko.leetcode.daily;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by momoko on 2021/3/4.
 * 给定一些标记了宽度和高度的信封，宽度和高度以整数对形式 (w, h) 出现。当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。
 * <p>
 * 请计算最多能有多少个信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。
 * <p>
 * 说明:
 * 不允许旋转信封。
 * <p>
 * 示例:
 * 输入: envelopes = [[5,4],[6,4],[6,7],[2,3]]
 * 输出: 3
 * 解释: 最多信封的个数为 3, 组合为: [2,3] => [5,4] => [6,7]。
 */
public class MaxEnvelopes {
    public static void main(String[] args) {
        int[][] arr = {{5,4},{6,4},{6,7},{2,3}};
        int num = maxEnvelopes(arr);
        System.out.println(num);
        Set<Integer> set = new HashSet<>();
    }
    /*
    这一题需要用到求最长递增子序列的算法，首先将整个数组按照宽排序，然后再在长中选取最长的递增子序列
    dp[i]是以第i个信封为最外层最多信封的个数
     */
    public static int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        if (n == 0) {
            return 0;
        }
        int[] dp = new int[n];
        //初始化时，每个以自己为外层的信封包含本身，所以为1
        Arrays.fill(dp, 1);
        int res = dp[0];
        //按照w进行排序
        Arrays.sort(envelopes, (o1, o2) -> o1[0] - o2[0]);
        //对排序好的w应的h选择最长递增子序列
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]){
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            res = Math.max(dp[i], res);
        }

        return res;
    }
}