package com.momoko.leetcode;

import java.util.Arrays;

/**
 * Created by momoko on 2021/2/12.
 */

/**
 * 爱丽丝和鲍勃有不同大小的糖果棒：A[i] 是爱丽丝拥有的第 i 根糖果棒的大小，B[j] 是鲍勃拥有的第 j 根糖果棒的大小。
 *
 * 因为他们是朋友，所以他们想交换一根糖果棒，这样交换后，他们都有相同的糖果总量。（一个人拥有的糖果总量是他们拥有的糖果棒大小的总和。）
 *
 * 返回一个整数数组 ans，其中 ans[0] 是爱丽丝必须交换的糖果棒的大小，ans[1] 是 Bob 必须交换的糖果棒的大小。
 *
 * 如果有多个答案，你可以返回其中任何一个。保证答案存在。
 *
 *
 * sumA - sumB 差值其实就是交换需要弥补的差距
 * 定义需要取出来的是 xA 和 xB， 那么它们差值 xA - xB = (sumA - sumB) / 2
 * 思路就是：
 *
 * 按照从小到大的排序 A 和 B
 * 双指针，去遍历 A和 B， 考虑三种情况
 * xA-xB == (sumA - sumB) / 2 找到答案，返回即可
 *  xA-xB > (sumA - sumB) / 2 , 则增大 xB
 *  xA-xB < (sumA - sumB) / 2 , 则增大 xA
 */
public class FairCandySwap {
    public int[] fairCandySwap(int[] A, int[] B) {
        int[] res = new int[2];
        int sumA = Arrays.stream(A).sum();
        int sumB = Arrays.stream(B).sum();
        int mid = (sumA - sumB) / 2;
        Arrays.sort(A);
        Arrays.sort(B);
        int i,j,LA,LB;
        i = j = 0;
        LA = A.length;
        LB = B.length;
        while (i < LA && j < LB) {
            int cur = A[i] - B[i];
            if (cur == mid) {
                res[0] = A[i];
                res[1] = B[i];
            } else if (cur > mid) {
                j++;
            } else {
                i++;
            }
        }
        return res;
    }
}