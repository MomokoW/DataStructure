package com.momoko.learn_string;

/**
 * Created by momoko on 2021/2/27.
 */
public class ReverseString {
    public static void main(String[] args) {

    }
    public static void reverseString(char[] s) {
        int start = 0, end = s.length - 1;
        char temp = ' ';
        while (start < end) {
            temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            //记得控制循环条件
            start++;
            end--;
        }
    }
}