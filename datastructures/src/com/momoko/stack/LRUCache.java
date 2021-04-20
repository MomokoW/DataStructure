package com.momoko.stack;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by momoko on 2021/4/5.
 */
public class LRUCache {
    Map<Integer, Integer> map;
    List<Integer> list;
    int size;
    public LRUCache(int capacity) {
        map = new HashMap<>();
        list = new ArrayList<>();
        size = capacity;
    }

    public int get(int key) {
        //每次取数时都将该数移到队首
        if (map.get(key) != null) {
            list.remove(Integer.valueOf(key));
            list.add(key);
        }
        return map.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        if (list.size() < size) {
            if (list.contains(key)) {
                list.remove(Integer.valueOf(key));
            }
        } else {
            //替换掉出现次数最少的，即index为0的位置
            Integer num = list.remove(0);
            map.remove(num);
        }
        list.add(key);
        map.put(key, value);
    }
}