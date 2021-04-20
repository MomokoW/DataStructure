package com.momoko.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by momoko on 2021/4/1.
 */
public class L1006 {
    public static void main(String[] args) {
        L1006 l1006 = new L1006();
        l1006.clumsy(10);
    }

    public int clumsy(int N) {
        //双栈解决法，使用栈来完成表达式的计算
        Deque<Integer> nums = new ArrayDeque<>();
        Deque<Character> opts = new ArrayDeque<>();
        //保存运算符优先级
        Map<Character, Integer> priors = new HashMap<>() {{
            put('*', 2);
            put('/', 2);
            put('+', 1);
            put('-', 1);
        }};
        char[] cs = new char[]{'*','/','+','-'};
        //将操作数和操作符都入队
        for (int i = N, j = 0; i > 0; i--, j++) {
            char op = cs[j % 4];
            nums.addLast(i);
            //边读取数据边运算，判断
            while (!opts.isEmpty() && priors.get(op) <= priors.get(opts.peekLast())) {
                calc (nums, opts);
            }
            if (i != 1) opts.offerLast(op);
        }
        while (!opts.isEmpty()) calc(nums, opts);
        return nums.peekLast();


    }
    public void calc(Deque<Integer> nums, Deque<Character> opts) {
        int b = nums.pollLast(), a = nums.pollLast();
        char op = opts.pollLast();
        int ans = 0;
        if (op == '*') ans = a * b;
        if (op == '/') ans = a / b;
        if (op == '+') ans = a + b;
        if (op == '-') ans = a - b;
        nums.offerLast(ans);
    }
}