package inteview.concurrent.juc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by momoko on 2021/7/8.
 * 三个线程分别打印 A，B，C，要求这三个线程一起运行，打印 n 次，输出形如“ABCABCABC....“的字符串
 * main 方法启动后，3 个线程会抢锁，但是 state 的初始值为 0，所以第一次执行 if 语句的内容只能是 线程 A，
 * 然后还在 for 循环之内，此时state = 1，只有 线程 B 才满足 1% 3 == 1，所以第二个执行的是 B，
 * 同理只有 线程 C 才满足 2% 3 == 2，所以第三个执行的是 C，执行完 ABC 之后，才去执行第二次 for 循环，
 * 所以要把 i++ 写在 for 循环里边，不能写成 for (int i = 0; i < times;i++) 这样。
 */
public class PrintABCUsingLock {
    private int times;  // 控制打印次数
    private int state;  // 当前状态值：保证三个线程之间交替打印
    private final Lock lock = new ReentrantLock();

    public PrintABCUsingLock(int times) {
        this.times = times;
    }

    private void printLetter(String name, int targetNum, int count) {
        for (int i = 0; i < times;) {
            lock.lock();
            if (state % 3 == targetNum) {
                state++;
                i++;
                for (int j = 0; j < count; j++) {
                    System.out.print(name);
                }
                if (state % 3 == 0) {
                    System.out.println();
                }
            }

            lock.unlock();
        }
    }

    public static void main(String[] args) {
        PrintABCUsingLock loopThread = new PrintABCUsingLock(10);
        new Thread(() -> {
            loopThread.printLetter("B", 1, 10);
        }, "B").start();

        new Thread(() -> {
            loopThread.printLetter("A", 0, 5);
        }, "A").start();

        new Thread(() -> {
            loopThread.printLetter("C", 2, 15);
        }, "C").start();

    }

}
