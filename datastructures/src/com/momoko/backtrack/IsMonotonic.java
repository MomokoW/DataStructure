package com.momoko.backtrack;

/**
 * 如果数组是单调递增或单调递减的，那么它是单调的。
 *
 * 如果对于所有 i <= j，A[i] <= A[j]，那么数组 A 是单调递增的。 如果对于所有 i <= j，A[i]> = A[j]，那么数组 A 是单调递减的。
 *
 * 当给定的数组 A是单调数组时返回 true，否则返回 false。
 *
 */
public class IsMonotonic {
    public static void main(String[] args) {

    }

    //第一想法，双指针，但是需要遍历完整个数组，可以先拿前两个数来判断是否为增
    public boolean isMonotonic(int[] A) {
        if (A.length == 1 || A.length == 2)
            return true;
        boolean isAsc = false, isDesc = false;
        if (A[0] <= A[1] && A[1] <= A[2]) {
            isAsc = true;
        }
        if (A[0] >= A[1] && A[1] >= A[2]) {
            isDesc = true;
        }
        for (int i = 0, j = 1; j < A.length; i++, j++) {
            if (isAsc && (A[i] > A[j]))
                return false;
            if (isDesc && (A[i] < A[j])) {
                return false;
            }
        }
        return true;
    }
}
