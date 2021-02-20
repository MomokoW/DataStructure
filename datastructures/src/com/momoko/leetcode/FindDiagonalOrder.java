package com.momoko.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by momoko on 2021/2/19.
 * 给定一个含有 M x N 个元素的矩阵（M 行，N 列），请以对角线遍历的顺序返回这个矩阵中的所有元素
 * 输入:
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 *
 * 输出:  [1,2,4,7,5,3,6,8,9]
 *
 */
public class FindDiagonalOrder {
    public static void main(String[] args) {
        int[][] arr =  {{ 1, 2, 3 }, { 4, 5, 6 }, {7, 8, 9}};
        int[] nums = findDiagonalOrder(arr);
        System.out.println(Arrays.toString(nums));

    }

    public static int[] findDiagonalOrder(int[][] matrix) {
        if (matrix[0].length == 0) {
            return new int[0];
        }
        List<Integer> list = new ArrayList<>();

        //flag判断遍历的方向 0 为向上，1为向下
        int flag = 0;
        int i = 0;
        int j = 0;
        while (i != matrix.length - 1 || j != matrix[0].length - 1) {
            list.add(matrix[i][j]);
            //向上
            if (flag == 0) {
                i -= 1;
                j += 1;
            } else {   //向下
                i += 1;
                j -= 1;
            }
            //判断越界的条件，有四种，分别为到达上边界，到达左边界，到达下边界，到达右边界
            if (i < 0 && j < matrix[0].length && j >= 0) { //i越下界
                i += 1;
                flag = 1;
            } else if (i >= 0 && i < matrix.length && j < 0) { //j越下界
                j += 1;
                flag = 0;
            } else if (j == matrix[0].length) { //j越上界
                i += 2;
                j -= 1;
                flag = 1;
            } else if (i == matrix.length) { //i越上界
                i -= 1;
                j += 2;
                flag = 0;
            }
        }
        //添加最后一个元素到数组中
        list.add(matrix[i][j]);

        return list.stream().mapToInt(Integer::valueOf).toArray();
    }

}