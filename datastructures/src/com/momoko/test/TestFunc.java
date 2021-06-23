package com.momoko.test;

import com.momoko.linkedlist.ListNode;

import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.Scanner;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.IntStream;

/**
 * Created by momoko on 2021/1/29.
 */
public class TestFunc {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append("123456");
        sb.delete(sb.length() - 1, sb.length());
        System.out.println(sb);
        Set<String> set = new HashSet<>();
        char[] ch = {'a','b','c'};
        List<Integer> list = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>(list);

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
