package com.momoko.bfs;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by momoko on 2021/3/8.
 */
public class NumIslands {
    public static void main(String[] args) {
        char[][] grid = {{'1','1','0','0','0'}, {'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};
        int num = numIslands(grid);
        int sqrt = (int) Math.sqrt(9);
        Deque<Integer> stack = new LinkedList<>();
        stack.push(1);
        stack.pop();
        System.out.println(stack);


    }

    public static int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != '0') {
                    //先判断四周是否都相连了
                    if ((i - 1 >= 0 && visited[i - 1][j]) || (i + 1 < m && visited[i + 1][j]) || (j - 1 >= 0 && visited[i][j - 1]) || (j + 1 < n && visited[i][j + 1])) {
                        visited[i][j] = true;
                    }
                    //如果都没被访问到，则为独立的岛屿
                    if (!visited[i][j]) {
                        count++;
                    }
                    //让右边和下面的岛屿都变为已访问状态（如果存在的话）
                    if (i + 1 < m && grid[i + 1][j] != '0') {
                        visited[i + 1][j] = true;
                    }
                    if (j + 1 < n && grid[i][j + 1] != '0') {
                        visited[i][j + 1] = true;
                    }
                }
            }
        }
        return count;
    }
}