package com.momoko.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.Set;
import java.util.stream.IntStream;

/**
 * Created by momoko on 2021/1/29.
 */
public class TestFunc {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap();

        Set<Integer> set = new HashSet<>();
        int[] A = new int[4];
        int[] B = new int[4];
        for (int a : A) for (int b : B) map.put(a + b, map.getOrDefault(a + b, 0) + 1);
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        int[] nums = {1, 1, 1, 2, 3};
        List<Integer> list = new ArrayList<>();
        Random random = new Random();
        random.nextInt();
        String s = "we are the champions";
        

    }
}