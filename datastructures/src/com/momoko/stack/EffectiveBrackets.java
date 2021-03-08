package com.momoko.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by momoko on 2021/3/8.
 */
public class EffectiveBrackets {
    public static void main(String[] args) {
        String s = "{]";
        isValid(s);
    }
    public static boolean isValid(String s) {
        if (s == null) {
            return true;
        }
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') continue;
            if (c == '(' || c == '{' || c == '[') {
                // 如果是左括号，则直接入栈
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                // 判断栈顶元素是否等于左括号对应的右括号
                char topElement = stack.pop();
                char matched = '#';
                if (c == ')')
                    matched = '(';
                else if (c == ']')
                    matched = '[';
                else
                    matched = '{';
                if (matched != topElement)
                    return false;
            }
        }
        // 如果栈不为空，那么也算没有匹配好
        return stack.isEmpty();
    }


}