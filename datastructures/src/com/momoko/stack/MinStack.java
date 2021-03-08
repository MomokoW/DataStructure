package com.momoko.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by momoko on 2021/3/8.
 */
public class MinStack {
    Deque<Integer> stack;
    Deque<Integer> min_stack;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new LinkedList<>();
        min_stack = new LinkedList<>();
        min_stack.push(Integer.MAX_VALUE);
    }

    public void push(int x) {
        stack.push(x);
        min_stack.push(Math.min(min_stack.peek(), x));
    }

    public void pop() {
        if (!stack.isEmpty()) {
            stack.pop();
            min_stack.pop();
        }
    }

    public int top() {
        if (!stack.isEmpty()) {
            return stack.peek();
        }
        return -1;
    }

    public int getMin() {
        return min_stack.pop();
    }
}