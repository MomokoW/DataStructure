package com.momoko.leetcode.daily;

import java.util.Stack;

/**
 * Created by momoko on 2021/3/5.
 * 请你仅使用两个栈实现先入先出队列。队列应当支持一般队列的支持的所有操作（push、pop、peek、empty）：
 *
 * 实现 MyQueue 类：
 *
 * void push(int x) 将元素 x 推到队列的末尾
 * int pop() 从队列的开头移除并返回元素
 * int peek() 返回队列开头的元素
 * boolean empty() 如果队列为空，返回 true ；否则，返回 false
 */
public class MyQueue {
    Stack<Integer> ins;
    Stack<Integer> outs;
    /** Initialize your data structure here. */
    public MyQueue() {
        ins = new Stack<>();
        outs = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        ins.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        //如果outs栈为空，则将ins中的元素全部pop到outs中
        if (outs.isEmpty()) {
            while (!ins.isEmpty()) {
                outs.push(ins.pop());
            }
        }
        return outs.pop();
    }

    /** Get the front element. */
    public int peek() {
        //先pop一下，再push进去
        int res = pop();
        outs.push(res);
        return res;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return ins.isEmpty() && outs.isEmpty();
    }
}