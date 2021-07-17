package com.momoko.test;

import com.momoko.linkedlist.ListNode;

import java.lang.reflect.Array;
import java.util.*;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * Created by momoko on 2021/1/29.
 */
public class TestFunc {

    public static void main(String[] args) {
    }


    public static int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            if (n % 2 != 0) {
                count++;
            }
            n >>= 1;
        }
        return count;
    }

    public int maxResult(int[] nums, int k) { // 贪心
        int res = 0;
        int cur = 0;
        int n = nums.length;
        while (cur < n) {
            int min = Integer.MIN_VALUE;
            int minIndex = Integer.MIN_VALUE;
            int len = Math.min(cur + k - 1, n - 1);
            for (int i = cur; i <= len; i++) {
                if (nums[i] >= 0) {
                    min = nums[i];
                    minIndex = i;
                    break;
                } else {
                    if (nums[i] >= min) {
                        min = nums[i];
                        minIndex = i;
                    }
                }
            }
            res += min;
            cur = minIndex;
            cur++;
        }
        return res;
    }
}
