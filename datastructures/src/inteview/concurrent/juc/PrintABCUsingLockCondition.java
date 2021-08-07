package inteview.concurrent.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by momoko on 2021/7/8.
 */
public class PrintABCUsingLockCondition {
    private int times;
    private int state;
    private static Lock lock = new ReentrantLock();
    private static Condition c1 = lock.newCondition();
    private static Condition c2 = lock.newCondition();
    private static Condition c3 = lock.newCondition();

    public PrintABCUsingLockCondition(int times) {
        this.times = times;
    }

    private void printLetter(String name, int targetState, Condition current, Condition next, int count) {
        for (int i = 0; i < times;) {
            try {
                lock.lock();
                while (state % 3 != targetState) {
                    current.await();
                }
                state++;
                i++;
                for (int j = 0; j < count; j++) {
                    System.out.print(name);
                }
                next.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        PrintABCUsingLockCondition print = new PrintABCUsingLockCondition(10);
        new Thread(() -> {
            print.printLetter("A", 0, c1, c2, 5);
        }, "A").start();
        new Thread(() -> {
            print.printLetter("B", 1, c2, c3, 10);
        }, "B").start();
        new Thread(() -> {
            print.printLetter("C", 2, c3, c1, 15);
        }, "C").start();
    }
}
