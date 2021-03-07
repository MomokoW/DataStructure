package com.momoko.leetcode.daily;

import java.util.Arrays;

/**
 * Created by momoko on 2021/2/28.
 */
public class IsMonotonic {
    public static void main(String[] args) {
        int[] A = {1,2,2,3};
        boolean monotonic = isMonotonic(A);
    }

    public static boolean isMonotonic(int[] A) {
        boolean isAsc = true, isDesc = true;
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] > A[i + 1])
                isAsc = false;
            if ( A[i] < A[i + 1]) {
                isDesc = false;
            }
        }
        return isAsc || isDesc;
    }
}