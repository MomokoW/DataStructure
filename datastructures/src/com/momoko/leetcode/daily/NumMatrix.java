package com.momoko.leetcode.daily;

/**
 * Created by momoko on 2021/3/2.
 * 给定一个二维矩阵，计算其子矩形范围内元素的总和，该子矩阵的左上角为 (row1, col1) ，右下角为 (row2, col2)。
 * 上图子矩阵左上角 (row1, col1) = (2, 1) ，右下角(row2, col2) = (4, 3)，该子矩形内元素的总和为 8。
 */
public class NumMatrix {
    public static void main(String[] args) {
        int[][] arr = {{3, 0, 1, 4, 2}, {5, 6, 3, 2, 1}, {1, 2, 0, 1, 5}, {4, 1, 0, 1, 7}, {1, 0, 3, 0, 5}};
//        int[][] arr = {{-4,-5}};
        NumMatrix numMatrix = new NumMatrix(arr);
        int sum = numMatrix.sumRegion(0, 1, 0, 1);
        System.out.println(sum);
    }

    //用于储存矩阵前i行，前j列的和
    private int[][] sum;
    private boolean flag = true;
    public NumMatrix(int[][] matrix) {
        int row = matrix.length;
        if (matrix.length != 0) {
            int col = matrix[0].length;
            sum = new int[row][col];
            flag = false;
            int totalSum = 0;
            int temp1 = 0;
            int temp2 = 0;
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    totalSum += matrix[i][j];
                    if (i - 1 < 0) {
                        temp1 = 0;
                        temp2 = 0;
                    } else {
                        temp1 = sum[i - 1][col - 1];
                        temp2 = sum[i - 1][j];
                    }
                    sum[i][j] = totalSum - (temp1 - temp2);
                }
            }
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    System.out.print(sum[i][j] + " ");
                }
                System.out.println();
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (!flag) {
            int temp1 = 0, temp2 = 0, temp3 = 0;
            if (row1 - 1 >= 0 && col2 >= 0) {
                temp1 = sum[row1 - 1][col2];
            }
            if (row2 >= 0 && col1 - 1 >= 0) {
                temp2 = sum[row2][col1 - 1];
            }
            if (row1 - 1 >= 0 && col1 - 1 >= 0){
                temp3 = sum[row1 - 1][col1 - 1];
            }
            return sum[row2][col2] - temp1 - temp2 + temp3;
        } else {
            return 0;
        }
    }
}