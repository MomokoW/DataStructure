package com.momoko.common_algorithm;

/**
 * Created by momoko on 2021/2/26.
 */
public class KMPAlgorithm {
    public static void main(String[] args) {
        String str = "BBC ABCDAB ABCDABCDABDE";
        String str2 = "ABCDABD";
        int[] next = kmpNext(str2);
        int index = kmpSearch(str, str2, next);
        System.out.println(index);
    }

    //写出KMP搜索算法

    /**
     * @param str1 源字符串
     * @param str2 子串
     * @param next next部分匹配表，是子串对应的部分匹配表
     * @return 如果是-1就是没有匹配到，否则返回第一个匹配的位置
     */
    public static int kmpSearch(String str1, String str2, int[] next) {
        //遍历源串
        for (int i = 0, j = 0; i < str1.length(); i++) {
            //需要处理str1.charAt(i) != str2.charAt(j)，去调整j的大小
            while (j > 0 && str1.charAt(i) != str2.charAt(j)) {
                j = next[j - 1];
            }
            if (str1.charAt(i) == str2.charAt(j)) {
                j++;
            }
            if (j == str2.length()) {  //找到了
                return i - j + 1;
            }

        }
        return -1;
    }

    //获取到一个字符串(子串)的部分匹配值表
    public static int[] kmpNext(String dest) {
        //创建一个next数组保存部分匹配值
        int[] next = new int[dest.length()];
        next[0] = 0;    //如果字符串长度为1，部分匹配值就是0，应该说，子串的第一个字符的前缀和后缀公共长度绝对为0
        for (int i = 1, j = 0; i < dest.length(); i++) {
            //当dest.charAt(i) != dest.charAt(j)时，需要从next[j - 1]获取新的j
            //直到我们发现有dest.charAt(i) == dest.charAt(j)成立才退出
            while (j > 0 && dest.charAt(i) != dest.charAt(j)) {
                j = next[j - 1];
            }
            //满足下面这个条件时，部分匹配值+1
            if (dest.charAt(i) == dest.charAt(j)) {
                j++;
            } 
            next[i] = j;
        }
        return next;
    }
}