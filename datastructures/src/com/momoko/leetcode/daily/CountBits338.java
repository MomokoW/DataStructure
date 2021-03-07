package com.momoko.leetcode.daily;

import java.util.Arrays;

/**
 * Created by momoko on 2021/3/3.
 */
public class CountBits338 {
    public static void main(String[] args) {
        int[] arr = countBits(2);
        System.out.println(Arrays.toString(arr));
    }

    //方法一：对每个数都进行计算
//    public static int[] countBits(int num) {
//        int[] result = new int[num + 1];
//        for (int i = 0; i <= num; i++) {
//            int count = countBit(i);
//            result[i] = count;
//        }
//        return result;
//    }


    //方法二：利用奇偶性进行判断，可以看到，偶数中1的个数和它除二的数的个数一样多，而奇数中1的个数比前一个偶数多1
    public static int[] countBits(int num) {
        int[] result = new int[num + 1];
        result[0] = 0;
        for (int i = 1; i <= num ; i++) {
            if (i % 2 == 1) {
                result[i] = result[i - 1] + 1;
            } else {
                result[i] = result[i / 2];
            }
        }
        return result;
    }


    public static int countBit(int num) {
        int count = 0;
        while (num > 0) {
            if (num % 2 != 0) {
                count++;
            }
            num >>= 1;
        }
        return count;
    }
}