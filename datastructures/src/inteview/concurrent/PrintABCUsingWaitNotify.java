package inteview.concurrent;

import java.util.concurrent.locks.Lock;

/**
 * Created by momoko on 2021/7/8.
 */
public class PrintABCUsingWaitNotify {
    private int state;
    private int times;
    private static final Object LOCK = new Object();

    public PrintABCUsingWaitNotify(int times) {
        this.times = times;
    }

    public void printLetter(String name, int targetState) {
        for (int i = 0; i < times; i++) {
            synchronized (LOCK) {
                while (state % 3 != targetState) {
                    try {
                        LOCK.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                state++;
                System.out.print(name);
                LOCK.notifyAll();
            }
        }
    }

    public static void main(String[] args) {
        PrintABCUsingWaitNotify printABC = new PrintABCUsingWaitNotify(10);
        new Thread(() -> {
            printABC.printLetter("A", 0);
        }).start();

        new Thread(() -> {
            printABC.printLetter("B", 1);
        }).start();

        new Thread(() -> {
            printABC.printLetter("C", 2);
        }).start();
    }

}
