package inteview.concurrent.juc;

/**
 * Created by momoko on 2021/7/8.
 * 线程1打印123
 * 线程2打印ABC
 * 线程3打印abc
 * 交替打印1Aa2Bb3Cc
 */
public class Print1AaUsingWaitNotify {
    private int state;
    private int times;
    private static final Object LOCK = new Object();

    public Print1AaUsingWaitNotify(int times) {
        this.times = times;
    }

    public void printLetter(char ch, int targetState) {
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
                System.out.print((char)(ch + i));
                LOCK.notifyAll();
            }
        }
    }

    public static void main(String[] args) {
        Print1AaUsingWaitNotify printABC = new Print1AaUsingWaitNotify(3);
        new Thread(() -> {
            printABC.printLetter('1', 0);
        }).start();

        new Thread(() -> {
            printABC.printLetter('A', 1);
        }).start();

        new Thread(() -> {
            printABC.printLetter('a', 2);
        }).start();
    }

}
