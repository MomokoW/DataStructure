package com.momoko.test;

import com.momoko.linkedlist.ListNode;

import java.lang.reflect.Array;
import java.util.*;
import java.util.Scanner;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.stream.IntStream;

/**
 * Created by momoko on 2021/1/29.
 */
public class TestFunc {

    public static void main(String[] args) {
        int num = testTryCatch();
        System.out.println(num);
        Map<Integer, Integer> map = new TreeMap<>();
        for (Map.Entry<Integer, Integer> integerIntegerEntry : map.entrySet()) {

        }
        StringBuilder sb = new StringBuilder();
        Deque<Integer> stack = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        list.sort(Comparator.comparingInt(o -> o));


    }

    public static int testTryCatch() {

        try {
            int i = 1/ 0;
        } catch (Exception e) {
            e.printStackTrace();
            return 1;
        } finally {
            return 2;
        }
    }

    class Node {
        int row;
        int compower;

        public Node(int row, int compower) {
            this.row = row;
            this.compower = compower;
        }

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
