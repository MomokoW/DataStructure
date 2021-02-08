package com.momoko.stack;

import java.util.Scanner;

/**
 * Created by momoko on 2021/2/3.
 */
public class ArrayStackDemo {
    public static void main(String[] args) {
//        ArrayStack stack = new ArrayStack(6);
        LinkedStack stack = new LinkedStack(6);
        String key = "";
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);
        while (loop) {
            System.out.println("show：表示显示栈");
            System.out.println("exit：退出程序");
            System.out.println("push：添加数据到栈中(入栈)");
            System.out.println("pop：从栈中取出数据(出栈)");
            System.out.println("请输入你的选择：");
            key = scanner.next();
            switch (key) {
                case "show":
                    stack.list();
                    break;
                case "push":
                    System.out.println("请输入一个数");
                    int value = scanner.nextInt();
                    stack.push(value);
                    break;
                case "pop":
                    try {
                        int value2 = stack.pop();
                        System.out.println("出栈的数据为：" + value2);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "exit":
                    //记得关闭流
                    scanner.close();
                    loop = false;
                    System.out.println("退出程序，bye~");
                    break;
                default:
                    break;
            }

        }
    }
}

class ArrayStack {
    private int maxSize;   //栈的大小
    private int[] stack;   //数组模拟栈
    private int top = -1;  //top表示栈顶

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    //判断是否栈满
    public boolean isFull() {
        return top == maxSize - 1;
    }

    //栈空
    public boolean isEmpty() {
        return top == -1;
    }

    //入栈
    public void push(int value) {
        //先判断栈是否满
        if (isFull()) {
            System.out.println("栈已经满了");
            return;
        }
        stack[++top] = value;
    }

    //出栈
    public int pop() {
        //先判断是否栈空
        if (isEmpty()) {
            throw new RuntimeException("栈空，没有数据");
        }
        return stack[top--];
    }

    //遍历栈
    public void list() {
        if (isEmpty()) {
            System.out.println("栈空，没有数据");
        }
        for (int i = top; i >= 0; i--) {
            System.out.println(stack[i]);
        }
    }
}