package com.momoko.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by momoko on 2021/2/19.
 */
public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        int minLen = Arrays.stream(strs).mapToInt(String::length).min().orElse(0);
        if (minLen == 0) {
            return "";
        }
        String subString = "";
        int endIndex = 0;
        outer:for (int i = 0; i < minLen; i++) {
            subString = strs[0].substring(0,i + 1);
            endIndex = i + 1;
            for (String str : strs) {
                if (!subString.equals(str.substring(0,endIndex))) {
                    endIndex--;
                    break outer;
                }
            }
        }
        return strs[0].substring(0,endIndex);
    }

    public static void main(String[] args) {
        String[] strs = {"a","ab","abb"};
        String str = "a";
        String substring = str.substring(0, 0);
        System.out.println(substring);


        String s = longestCommonPrefix(strs);
        System.out.println(s);
        s.startsWith()


    }

    /**
     * 居然忘记了startWith这个函数，太不应该了
     */
}