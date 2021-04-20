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
        String s = "abcde";
        Set<String> set = new HashSet<>();

        for (int i = s.length(); i > 0; i--) {
            System.out.println(s.substring(0, i));
        }


        char[] arr = new char[3];

        try {
            Integer.parseInt(String.valueOf(arr));
        } catch (NumberFormatException e) {
            e.printStackTrace();
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
}