package com.momoko.leetcode;

/**
 * Created by momoko on 2021/2/17.
 * 在MATLAB中，有一个非常有用的函数 reshape，它可以将一个矩阵重塑为另一个大小不同的新矩阵，但保留其原始数据。
 *
 * 给出一个由二维数组表示的矩阵，以及两个正整数r和c，分别表示想要的重构的矩阵的行数和列数。
 *
 * 重构后的矩阵需要将原始矩阵的所有元素以相同的行遍历顺序填充。
 *
 * 如果具有给定参数的reshape操作是可行且合理的，则输出新的重塑矩阵；否则，输出原始矩阵。
 *
 */

public class MatrixReshape {
    public static int[][] matrixReshape(int[][] nums, int r, int c) {
        int length = nums.length;
        int width = nums[0].length;
        if (length * width != r * c) {
            return nums;
        }
        //可重塑为长为r，宽为c矩阵
        int row = 0;
        int col = 0;
        int[][] arr = new int[r][c];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                if (col < c) {
                    arr[row][col] = nums[i][j];
                    col++;
                } else {
                    col = 0;
                    if (row < r) {
                        row++;
                        arr[row][col] = nums[i][j];
                        col++;
                    }
                }
            }
        }
        return arr;

        /**
         * 更简单的做法
         * (i,j)→i×n+j,对于在数组m*n中的第x个元素，在数组中的下标为(x/n,x%n)
         */
    }

    public static void main(String[] args) {
        int[][] nums = {{1,2},{3,4}};
        int[][] ints = matrixReshape(nums, 4, 1);
        for (int[] num : ints) {
            for (int i : num) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}