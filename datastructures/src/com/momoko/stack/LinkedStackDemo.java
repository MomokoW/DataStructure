package com.momoko.stack;

/**
 * Created by momoko on 2021/2/4.
 */
public class LinkedStackDemo {
    public static void main(String[] args) {

    }
}

class LinkedStack {
    private int maxSize;    //栈的大小
    private int num = 0;    //栈中数据的个数
    private Node head = new Node(-1);  //链表的头节点

    public LinkedStack(int maxSize) {
        this.maxSize = maxSize;
    }

    //判断是否栈满
    public boolean isFull() {
        return num == maxSize;
    }

    //栈空
    public boolean isEmpty() {
        return num == 0;
    }

    //入栈,添加的数据放到head后面
    public void push(int value) {
        //先判断栈是否满
        if (isFull()) {
            System.out.println("栈已经满了");
            return;
        }
        Node node = new Node(value);
        node.next = head.next;
        head.next = node;
        num++;

    }

    //出栈,从head后面删除数据
    public int pop() {
        //先判断是否栈空
        if (isEmpty()) {
            throw new RuntimeException("栈空，没有数据");
        }
        int value = head.next.element;
        head.next = head.next.next;
        num--;
        return value;
    }

    //遍历栈
    public void list() {
        if (isEmpty()) {
            System.out.println("栈空，没有数据");
        }
        //遍历链表
        Node temp = head.next;
        while (temp != null) {
            System.out.println(temp.element);
            temp = temp.next;
        }
    }
}

/**
 * 表示栈的一个节点
 */
class Node {
    int element;
    Node next;

    public Node(int element) {
        this.element = element;
    }
}