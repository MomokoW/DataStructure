package com.momoko.array;

import java.util.Arrays;

/**
 * Created by momoko on 2021/3/16.
 * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 */
public class GenerateMatrix {
    public static void main(String[] args) {
        int[][] ints = generateMatrix(1);
        for (int[] anInt : ints) {
            System.out.println(Arrays.toString(anInt));
        }
    }
    public static int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int left = 0, right = n - 1, up = 0, down = n - 1;
        int num = 1;
        while (true) {
            for (int i = left; i <= right; i++) {
                matrix[up][i] = num;
                num++;
            }
            if(++up > down) break;
            for (int i = up; i <= down; i++) {
                matrix[i][right] = num;
                num++;
            }
            if (--right < left) break;
            for (int i = right; i >= left; i--) {
                matrix[down][i] = num;
                num++;
            }
            if (--down < up) break;
            for (int i = down; i >= up; i--) {
                matrix[i][left] = num;
                num++;
            }
            if (++left > right) break;
        }
        return matrix;
    }
}