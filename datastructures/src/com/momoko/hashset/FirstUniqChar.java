package com.momoko.hashset;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by momoko on 2021/3/16.
 */
public class FirstUniqChar {
    public static void main(String[] args) {
        String s = "leetcode";
        firstUniqChar(s);
    }
    public static int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        //找出第一个出现只出现一次的字符
        Set<Character> set = map.keySet();
        for (Character character : set) {
            if (map.get(character) == 1) {
                return s.indexOf(character);
            }
        }
        return -1;
    }
}