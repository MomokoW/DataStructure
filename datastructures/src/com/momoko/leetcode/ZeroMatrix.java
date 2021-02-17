package com.momoko.leetcode;

import java.util.Arrays;

/**
 * Created by momoko on 2021/2/16.
 * 编写一种算法，若M × N矩阵中某个元素为0，则将其所在的行与列清零。
 */
public class ZeroMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1,1,1},{1,0,1},{1,1,1}};
        boolean[] row = new boolean[matrix.length];
        boolean[] col = new boolean[matrix[0].length];
        //思路，遍历数组，找到为0的元素，则记录下此时行号和列号，随后将十字线上的元素变为0
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }

        for (int i = 0; i < row.length; i++) {
            for (int j = 0; j < col.length; j++) {
                //该行或该列有为0的元素
                if (row[i] || col[j]) {
                    matrix[i][j] = 0;
                }

            }
        }

        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }
}