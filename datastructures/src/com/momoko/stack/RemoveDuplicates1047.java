package com.momoko.stack;

import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.Stack;

/**
 * Created by momoko on 2021/3/9.
 */
public class RemoveDuplicates1047 {
    public static void main(String[] args) {
        String s = "abbaca";
        String s1 = removeDuplicates(s);
        System.out.println(s1);
        Set<Integer> set = new HashSet<>();
        String s2 = "";
        s2 += "afg";

    }
    public static String removeDuplicates(String S) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            if (!stack.isEmpty() && stack.peek() == ch) {
                stack.pop();
            } else {
                stack.add(ch);
            }
        }
        StringBuilder sb = new StringBuilder();
        //输出栈顶元素，即为最终的结果
        for (Character character : stack) {
            sb.append(character);
        }
        return sb.toString();
    }
}