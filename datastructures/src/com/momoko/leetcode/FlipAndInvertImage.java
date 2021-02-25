package com.momoko.leetcode;

/**
 * Created by momoko on 2021/2/24.
 * 给定一个二进制矩阵 A，我们想先水平翻转图像，然后反转图像并返回结果。
 *
 * 水平翻转图片就是将图片的每一行都进行翻转，即逆序。例如，水平翻转 [1, 1, 0] 的结果是 [0, 1, 1]。
 *
 * 反转图片的意思是图片中的 0 全部被 1 替换， 1 全部被 0 替换。例如，反转 [0, 1, 1] 的结果是 [1, 0, 0]。
 *
 */
public class FlipAndInvertImage {
    public static int[][] flipAndInvertImage(int[][] A) {
        //其实也相当于双指针的做法
        if (A.length == 0 || A[0].length == 0)
            return new int[0][0];
        int temp = 0;
        int len = A[0].length - 1;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length / 2; j++) {
                A[i][j] = A[i][j] == 0 ? 1 : 0;
                A[i][len - j] = A[i][len - j] == 0 ? 1 : 0;
                temp = A[i][j];
                A[i][j] = A[i][len - j];
                A[i][len - j] = temp;
            }
            if (A[0].length % 2 != 0) {
                A[i][A[0].length / 2] = A[i][A[0].length / 2] == 0 ? 1 : 0;
            }
        }
        return A;
    }

    public static void main(String[] args) {
        int[][] arr = {{1,1,0},{1,0,1},{0,0,0}};
        int[][] ints = flipAndInvertImage(arr);
        for (int[] anInt : ints) {
            for (int i : anInt) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}