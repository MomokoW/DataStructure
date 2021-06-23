package com.momoko.hashmap;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by momoko on 2021/5/7.
 */
public class LeastBricks {
    public static void main(String[] args) {
        List<Integer> l1 = List.of(1, 2, 2, 1);
        List<Integer> l2 = List.of(3, 1, 2);
        List<Integer> l3 = List.of(1, 3, 2);
        List<Integer> l4 = List.of(2, 4);
        List<Integer> l5 = List.of(3, 1, 2);
        List<Integer> l6 = List.of(1, 3, 1, 1);
        List<List<Integer>> wall = List.of(l1, l2, l3, l4, l5, l6);
        leastBricks(wall);
    }
    public static int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> map = new HashMap<>();
        for (List<Integer> list : wall) {
            int sum = 0;
            for (Integer num : list) {
                sum += num;
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
            map.put(sum, 0);
        }
        int len = wall.size();
        int min = len;
        for (Integer sum : map.values()) {
            min = Math.min(min, len - sum);
        }
        return min;
    }
}