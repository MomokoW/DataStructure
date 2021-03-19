package com.momoko.hashset;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by momoko on 2021/3/18.
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 */
public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        int len = lengthOfLongestSubstring("abcabcbb");
    }

    public static int lengthOfLongestSubstring(String s) {
        //用哈希表将出现的字符存起来，双指针进行选择滑动
        Set<Character> set = new HashSet<>();
        int start = 0;
        int end = 0;
        int maxLen = 0;
        while (end < s.length()) {
            char ch = s.charAt(end);
            if (set.contains(ch)) {
                //重新不重复子串的最大长度
                maxLen = Math.max(maxLen, end - start);
                //重新选择不重复的子串,并将指针后移
                start = start + 1;
                end = start;
                //清空set中的数据
                set.clear();
            } else {
                set.add(ch);
                end++;
            }

        }
        return Math.max(maxLen, end - start);
    }
}