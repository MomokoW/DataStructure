package com.momoko.dp;

import java.util.Scanner;

/**
 * Created by momoko on 2021/2/25.
 */
public class NumberPyramid {
    private static int[][] D = new int[100][100];
    private static int[][] maxSum = new int[100][100];
    private static int[][] path = new int[100][100];
    private static int num;

    public static void main(String[] args) {
//        Scanner scan = new Scanner(System.in);
//        System.out.println("请输入数塔的层数:");
//        NumberPyramid.num = scan.nextInt();
//        for (int i = 1; i <= NumberPyramid.num; i++) {
//            for (int j = 1; j <= i; j++) {
//                D[i][j] = scan.nextInt();
//                maxSum[i][j] = -1;    //记录下每个位置向下的数塔的值
//            }
//        }
//        System.out.println("数塔的最大和为:" + maxSumNotes(1,1));
        maxSumDP();
    }
    //采用备忘录动态规划求解思路:自顶向下递归
    public static int maxSumNotes(int i, int j) {
        if (maxSum[i][j] != -1)   //之前已经求过
            return maxSum[i][j];

        if (i == num)
            maxSum[i][j] = D[i][j];
        else {
            int x = maxSumNotes(i + 1,j);
            int y = maxSumNotes(i + 1, j + 1);
            maxSum[i][j] = Math.max(x, y) + D[i][j];
        }
        return maxSum[i][j];
    }

    //采用自底向上的递推型动态规划求解

    /**
     * 1. 初始化数组maxSum的最后一行为数塔的底层数据：
     *     for (i = 1; i < =n; i++)          maxSum[n][i] = D[n][i];
     * 2. 从第n - 1层开始直到第 1 层对maxSum[i][j]执行下述操作：
     * 2.1maxSum[i][j]=max{maxSum[i+1][j], maxSum[i+1][j+1]}
     *                                +D[i][j]；
     * 2.2 如果选择下标j的元素，则path[i][j] = j，否则path[i][j] = j+1；
     * 3. 输出最大数值和maxSum[1][1]；
     * 4. 根据path数组确定每一层决策的列下标，输出路径信息；
     *
     */
    public static void maxSumDP() {
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入数塔的层数:");
        NumberPyramid.num = scan.nextInt();
        for (int i = 1; i <= NumberPyramid.num; i++) {
            for (int j = 1; j <= i; j++) {
                D[i][j] = scan.nextInt();
                maxSum[i][j] = -1;    //记录下每个位置向下的数塔的值
            }
        }

        for (int i = 1; i <= num; i++) {
            maxSum[num][i] = D[num][i];
        }
        for (int i = num - 1; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                if (maxSum[i + 1][j] > maxSum[i + 1][j + 1]) {
                    maxSum[i][j] = maxSum[i + 1][j] + D[i][j];
                    path[i][j] = j;
                } else {
                    maxSum[i][j] = maxSum[i + 1][j + 1] + D[i][j];
                    path[i][j] = j + 1;
                }
            }
        }
        System.out.print("路径为:" + D[1][1]);     //输出最顶层数字
        int j = path[1][1]; //顶层决策是选择下一层列下标为path[1][1]的元素
        for (int i = 2; i <= num; i++) {
            System.out.printf("-->%d", D[i][j]);
            j = path[i][j];        //本层决策是选择下一层列下标为path[i][j]的元素
        }
        System.out.printf("\n最大数值和为：%d", maxSum[1][1] );
    }

}