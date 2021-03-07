package com.momoko.binarysearch;

/**
 * Created by momoko on 2021/3/1.
 * 实现 int sqrt(int x) 函数。
 *
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 *
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 */
public class MySqrt {
    public int mySqrt(int x) {
        //思路，二分法，对于每个数，平方根肯定不会不会大于其一半
        long start = 0;
        long end = x / 2 + 1;
        while (start < end) {
            long mid = (start + end + 1) / 2;
            if (mid * mid > x) {
                end = mid - 1;
            } else {
                start = mid;
            }

        }
        return (int) start;
    }
}