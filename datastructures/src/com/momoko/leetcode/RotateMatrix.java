package com.momoko.leetcode;

import java.util.Arrays;

/**
 * Created by momoko on 2021/2/16.
 * 给你一幅由 N × N 矩阵表示的图像，其中每个像素的大小为 4 字节。请你设计一种算法，将图像旋转 90 度。
 *
 * 不占用额外内存空间能否做到？
 */
public class RotateMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};

        /**
         * 将矩阵旋转90度思路
         * 先将矩阵按照左右翻转，再按照副对角线翻转
         */
        //按照左右翻转
        int temp = 0;
        int len = matrix.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j <len / 2; j++) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[i][len - 1 - j];
                matrix[i][len - 1 - j] = temp;
            }
        }

        //再按照副对角线翻转
        for (int i = 0; i < len - 1; i++) {
            for (int j = 0; j < len - 1 - i; j++) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[len - 1 - j][len - 1 - i];
                matrix[len - 1 - j][len - 1 - i] = temp;
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