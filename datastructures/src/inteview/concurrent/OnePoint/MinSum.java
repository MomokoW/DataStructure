package inteview.concurrent.OnePoint;

/**
 * Created by momoko on 2021/7/30.
 */
public class MinSum {

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param mapArray int整型二维数组
     * @return int整型
     */
    public static int findMin (int[][] mapArray) {
        // write code here
        int M = mapArray.length;
        if (M == 0) {
            return 0;
        }
        int N = mapArray[0].length;
        if (N == 0) {
            return 0;
        }
        int[][] dp = new int[M][N];
        dp[0][0] = mapArray[0][0];
        for (int i = 1; i < M; i++) {
            dp[i][0] = dp[i - 1][0] + mapArray[i][0];
        }
        for (int i = 1; i < N; i++) {
            dp[0][i] = dp[0][i - 1] + mapArray[0][i];
        }
        for (int i = 1; i < M; i++) {
            for (int j = 1; j < N; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + mapArray[i][j];
            }
        }
        return dp[M - 1][N - 1];
    }

    public static void main(String[] args) {
        int[][] mapArray = {{1,3,1}, {1,5,1}, {4,2,1}};
        int min = findMin(mapArray);
        System.out.println(min);
    }
}
