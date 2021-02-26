package com.momoko.common_algorithm;

/**
 * Created by momoko on 2021/2/26.
 */
public class KMPAlgorithm {
    public static void main(String[] args) {
        String str = "BBC ABCDAB ABCDABCDABDE";
        String str2 = "ABCDABD";
    }

    //获取到一个字符串(子串)的部分匹配值表
    public static int[] kmpNext(String dest) {
        //创建一个next数组保存部分匹配值
        int[] next = new int[dest.length()];
        next[0] = 0;    //如果字符串长度为1，部分匹配值就是0，应该说，子串的第一个字符的前缀和后缀公共长度绝对为0
        for (int i = 1, j = 0; i < dest.length(); i++) {
            //满足下面这个条件时，部分匹配值+1
            if (dest.charAt(i) == dest.charAt(j)) {
                j++;
            } 
            next[i] = j;

        }
        return next;
    }
}