package com.momoko.recursion;

/**
 * Created by momoko on 2021/4/10.
 */
public class IsUgly {
    public static void main(String[] args) {
        isUgly(168);
    }
    public static boolean isUgly(int n) {
        if (n == 0) {
            return false;
        }
        if (n == 1 || n == 2 || n == 3 || n == 5) {
            return true;
        }
        if (n % 2 == 0) {
            return isUgly(n / 2);
        }
        if (n % 3 == 0) {
            return isUgly(n / 3);
        }
        if (n % 5 == 0) {
            return isUgly(n / 5);
        }
        return false;
    }
}