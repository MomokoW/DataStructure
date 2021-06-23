package com.momoko.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * Created by momoko on 2021/5/12.
 * 给定一个数组，找左边第一个比我大的元素的下标，如果没有，则置为 -1
 */
public class LeftFirstBigger {
    public static int[] findLeftLarge(int[] A) {
        if (A == null || A.length == 0) {
            return new int[0];
        }

        int N = A.length;
        int[] ans = new int[N];
        // 这里是递减栈
        Deque<Integer> stack = new ArrayDeque<Integer>();
        for (int i = N - 1; i >= 0; i--) {
            int x = A[i];
            while (!stack.isEmpty() && A[stack.peekLast()] < x) {
                ans[stack.pollLast()] = i;
            }
            stack.offerLast(i);
        }

        // 还在栈中的元素说明左边没有比它大的元素了
        while (!stack.isEmpty()) {
            ans[stack.pollLast()] = -1;
        }
        return ans;
    }
}
class Verify {
    private static int findLeftLarge(int[] A, int i) {
        for (int j = i - 1; j >= 0; j--) {
            if (A[j] > A[i]) {
                return j;
            }
        }
        return -1;
    }

    private static void check(int[] A, int[] ans) {
        if (A == null || A.length == 0) {
            return;
        }

        final int N = A.length;
        for (int i = 0; i < N; i++) {
            final int r = ans[i];
            if (r != findLeftLarge(A, i)) {
                System.out.println("ERROR");
            }
        }
    }

    public static void DoubleCheck(int[] A) {
        int[] ans = LeftFirstBigger.findLeftLarge(A);
        check(A, ans);
    }

    private static int NextInt() {
        final double d = Math.random();
        final int i = (int) (d * 1000);
        return i;
    }

    public static void RandomCheck() {
        for (int i = 0; i < 100; i++) {
            final int len = NextInt() + 1;
            int[] A = new int[len];
            for (int j = 0; j < len; j++) {
                A[j] = NextInt();
            }

            DoubleCheck(A);
        }
    }
}

class Practice03C {
    public static void main(String[] args) {
        Verify.DoubleCheck(new int[] { 5, 4 });
        Verify.DoubleCheck(new int[] { 1, 2, 4, 9, 4, 0, 5 });

        Verify.RandomCheck();

    }
}