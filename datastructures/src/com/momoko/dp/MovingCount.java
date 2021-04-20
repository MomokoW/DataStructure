package com.momoko.dp;

/**
 * Created by momoko on 2021/3/24.
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。
 * 一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），
 * 也不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。
 * 但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？

 */
public class MovingCount {
    public static void main(String[] args) {
        MovingCount mv = new MovingCount();
        int count = mv.movingCount(16, 8, 4);
        System.out.println(count);

    }
    //不能进入行坐标和列坐标的数位之和大于k的格子，需要把坐标位置给拆分开
    public int movingCount(int m, int n, int k) {
        int count = 0;
        boolean[][] visited = new boolean[m][n];
        count += dfs(visited, 0, 0, k, m, n);
        return count;
    }
    public int dfs(boolean[][] visited, int i, int j, int k, int m, int n) {
        int count = 0;
        //递归的终止条件
        if (i >= m || i < 0 || j >= n || j < 0 || visited[i][j] || i / 10 + i % 10 + j /10 + j % 10 > k) {
            return 0;
        }
        //加上从四个方向上搜索得到的结果
        count += 1;
        //置已访问标志
        visited[i][j] = true;
        count += dfs(visited, i - 1, j, k, m, n);
        count += dfs(visited, i + 1, j, k, m, n);
        count += dfs(visited, i, j + 1, k, m, n);
        count += dfs(visited, i, j - 1, k, m, n);
        return count;
    }

}