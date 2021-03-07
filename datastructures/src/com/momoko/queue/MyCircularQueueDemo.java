package com.momoko.queue;

/**
 * Created by momoko on 2021/3/7.
 */
public class MyCircularQueueDemo {
    public static void main(String[] args) {
        MyCircularQueue circularQueue = new MyCircularQueue(3);
        System.out.println(circularQueue.enQueue(1));
        System.out.println(circularQueue.enQueue(2));
        System.out.println(circularQueue.enQueue(3));
        System.out.println(circularQueue.enQueue(4));
        System.out.println(circularQueue.Rear());
        System.out.println(circularQueue.isFull());
        System.out.println(circularQueue.deQueue());
        System.out.println(circularQueue.enQueue(4));
        circularQueue.Rear();

    }

}
class MyCircularQueue {
    private int maxSize;   //表示数组的最大容量
    private int front;     //队列头
    private int rear;      //队列尾
    private int[] arr;     //用于存放数据

    public MyCircularQueue(int k) {
        maxSize = k + 1;    //会空出一个元素来判断队列是否满了
        arr = new int[maxSize];
        front = 0;    //指向队列头部，分析出front是指向队列的第一个元素，初始值为0
        rear = 0;     //指向队列尾，指向队列的最后一个数据的下一个数据，空出一个位置作为约定
    }

    public boolean enQueue(int value) {
        if (!isFull()) {
            arr[rear] = value;
            rear = (rear + 1) % maxSize;
            return true;
        }
        return false;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        int value = arr[front];
        front = (front + 1) % maxSize;
        return true;

    }

    public int Front() {
        if (isEmpty()){
            return -1;
        }
        return arr[front];
    }

    public int Rear() {
        if (isEmpty()){
            return -1;
        }
        if (rear - 1 < 0) {
            return arr[maxSize - 1];
        } else {
            return arr[rear - 1];
        }
    }

    public boolean isEmpty() {
        return front == rear;
    }

    public boolean isFull() {
        return front == ((rear + 1) % maxSize);
    }
}