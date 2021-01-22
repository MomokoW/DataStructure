package com.momoko.queue;

import java.util.Scanner;

/**
 * Created by momoko on 2021/1/22.
 */
public class ArrayQueueDemo {
    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(3);
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while(loop) {
            System.out.println("s(show):显示队列");
            System.out.println("e(exit):退出程序");
            System.out.println("a(add):添加数据到队列");
            System.out.println("g(get):从队列中取出数据");
            System.out.println("h(head):查看队列头的数据");
            key = scanner.next().charAt(0);

            switch (key) {
                case 's':
                    queue.showQueue();
                    break;
                case 'a':
                    System.out.println("输入一个数");
                    int value = scanner.nextInt();
                    queue.addQueue(value);
                    break;
                case 'g':
                    try {
                        int value1 = queue.deQueue();
                        System.out.println("数值: " + value1 + "出队");
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int value2 = queue.headQueue();
                        System.out.println("队列头的数据为: " + value2);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    System.out.println("程序退出");
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }

    }
}

//使用数组模拟队列———编写一个ArrayQueue类
class ArrayQueue {
    private int maxSize;   //表示数组的最大容量
    private int front;     //队列头
    private int rear;      //队列尾
    private int[] arr;     //用于存放数据

    //创建队列的构造器
    public ArrayQueue(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        front = -1;    //指向队列头部，分析出front是指向队列头的前一个位置
        rear = -1;     //指向队列尾，指向队列尾的数据（即就是队列的最后一个数）
    }

    //判断队列是否满
    public boolean isFull() {
        return rear == maxSize - 1;
    }

    //判断队列是否为空
    public boolean isEmpty() {
        return rear == front;
    }

    //添加数据到队列
    public void addQueue(int n) {
        //判断队列是否满
        if (isFull()) {
            System.out.println("队列满，不能加入数据");
            return;
        }
        rear++;
        arr[rear] = n;
    }

    //出队，获取队列的数据
    public int deQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列空，没有数据");
        }
        front++;
        return arr[front];
    }

    //显示队列的所有数据
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列为空，没有数据");
            return;
        }
        for (int i = front + 1; i <= rear; i++) {
            System.out.printf("arr[%d] = %d\n", i, arr[i]);
        }
    }

    //显示队列的头数据
    public int headQueue() {
        if (isEmpty()) {
            System.out.println("队列为空，没有数据");
            throw new RuntimeException("队列空，没有数据");
        }
        return arr[front + 1];
    }
}