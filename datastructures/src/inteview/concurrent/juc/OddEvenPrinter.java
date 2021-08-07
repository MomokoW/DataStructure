package inteview.concurrent.juc;

/**
 * Created by momoko on 2021/7/8.
 * 两个线程交替打印奇数和偶数
 */
public class OddEvenPrinter {
    private final Object monitor = new Object();
    private final int limit;
    private volatile int count;

    OddEvenPrinter(int initCount, int times) {
        count = initCount;
        limit = times;
    }

    private void print() {
        synchronized (monitor) {
            while (count < limit) {
                try {
                    System.out.printf("线程[%s]打印数字:%d%n", Thread.currentThread().getName(), ++count);

                    monitor.notifyAll();
                    monitor.wait();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //防止有子线程被阻塞未被唤醒，导致主线程不退出
            monitor.notifyAll();
        }
    }

    public static void main(String[] args) {
        OddEvenPrinter printer = new OddEvenPrinter(0, 10);
        new Thread(printer::print, "odd").start();
        new Thread(printer::print, "even").start();
    }

}
