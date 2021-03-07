package com.momoko.learn_string;

/**
 * Created by momoko on 2021/3/1.
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 * 输入："Let's take LeetCode contest"
 * 输出："s'teL ekat edoCteeL tsetnoc"
 * 在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
 */
public class reverseWords2 {
    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
        String s1 = reverseWords(s);
        System.out.println(s1);
    }

    public static String reverseWords(String s) {
        if(s.length() == 0) {
            return "";
        }
        char[] chars = s.toCharArray();
        //双指针
        int left = 0, right = 0;
        while (right < chars.length) {
            while (right < chars.length && chars[right] != ' ') {
                right++;
            }
            //翻转left ~ right - 1内的字符串
            reverse(chars, left, right - 1);
            right++;
            left = right;
        }
        return String.valueOf(chars);
    }
    public static void reverse(char[] arr, int start, int end) {
        char temp = ' ';
        while (start < end) {
            temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}