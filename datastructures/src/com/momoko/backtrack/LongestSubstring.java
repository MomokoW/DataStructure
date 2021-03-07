package com.momoko.backtrack;

import javax.swing.*;
import java.util.Arrays;
import java.util.HashMap;

/**
 * 给你一个字符串 s 和一个整数 k ，请你找出 s 中的最长子串， 要求该子串中的每一字符出现次数都不少于 k 。返回这一子串的长度。
 * 输入：s = "aaabb", k = 3
 * 输出：3
 * 解释：最长子串为 "aaa" ，其中 'a' 重复了 3 次
 *
 * s 仅由小写英文字母组成
 */
public class LongestSubstring {
    public static void main(String[] args) {
        String s = "aab";
        s.substring(0,1);
    }

    /*
    可以这样想，对于每个串，如果它有字符出现的次数少于k次，则所有包含这个字符串的字串都不可能成为目标子串
    则按照该串进行分割，对于分割后的串，继续进行这一操作
    递归停止条件：当子串的长度小于k时，肯定不满足条件，返回0
    未进入递归时的返回结果：如果 s 中的每个字符出现的次数都大于 k 次，那么 s 就是我们要求的字符串，直接返回该字符串的长度。
     */
    public static int longestSubstring(String s, int k) {
        if (s.length() < k)
            return 0;
        //计算子串中每个字符出现的次数
        HashMap<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0) + 1);
        }
        for (Character ch : map.keySet()) {
            if (map.get(ch) < k) {  //按这个字符进行分割
                int res = 0;
                for(String split : s.split(String.valueOf(ch))) {
                    //对每一个分割的子串都进行这个操作，返回最长的符合要求的子串
                    res = Math.max(res,longestSubstring(split, k));
                }
                //对每一次进行分割的结果都要进行返回
                return res;
            }
        }
        return s.length();
    }
}
