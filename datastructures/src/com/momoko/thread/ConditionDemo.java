package com.momoko.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by momoko on 2021/6/22.
 * 三个线程交叉打印，按ABC的顺序
 */
public class ConditionDemo {
    private static int num = 1;   //“谁”在打印
    private static Lock lock = new ReentrantLock();
    private static final Condition conditionA = lock.newCondition();
    private static final Condition conditionB = lock.newCondition();
    private static final Condition conditionC = lock.newCondition();

    // 打印10次
    private static CountDownLatch countDownLatch = new CountDownLatch(10);

    public static void main(String[] args) throws Exception {
//        System.out.println(conditionA == conditionB);
        long loop = countDownLatch.getCount();   //获取打印轮数
        new Thread(() -> {
            for (int i = 1; i <= loop; i++) {
                try{
                    printA();
                } catch (InterruptedException e) {
                }
            }
        }, "A").start();

        new Thread(() -> {
            for (int i = 1; i <= loop; i++) {
                try{
                    printB();
                } catch (InterruptedException e) {
                }
            }
        }, "B").start();

        new Thread(() -> {
            for (int i = 1; i <= loop; i++) {
                try{
                    printC(i);
                } catch (InterruptedException e) {
                }
            }
        }, "C").start();

        countDownLatch.await();
        System.out.println("打印完毕。。。。");
    }

    private static void printC(long loop) throws InterruptedException {
        // 获取锁
        lock.lock();
        if (num != 3) {
            conditionC.await();
        }
        System.out.print(Thread.currentThread().getName());
        System.out.print("[" + loop + "]");
        num = 1;
        conditionA.signal();
        countDownLatch.countDown();
        // 释放锁
        lock.unlock();

    }

    private static void printB() throws InterruptedException {
        // 获取锁
        lock.lock();
        if (num != 2) {
            conditionB.await();
        }
        System.out.print(Thread.currentThread().getName());
        num = 3;
        conditionC.signal();
        lock.unlock();
    }

    private static void printA() throws InterruptedException {
        // 获取锁
        lock.lock();
        if (num != 1) { //标识符等于1的时候打印A
            conditionA.await();
        }
        System.out.print(Thread.currentThread().getName());
        num = 2;
        conditionB.signal();
        lock.unlock();
    }
}
