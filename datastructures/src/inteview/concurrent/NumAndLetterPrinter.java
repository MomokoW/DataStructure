package inteview.concurrent;

/**
 * Created by momoko on 2021/7/8.
 * 用两个线程，一个输出字母，一个输出数字，交替输出 1A2B3C4D...26Z
 */
public class NumAndLetterPrinter {
    static final Object lock = new Object();

    public static void main(String[] args) {
        new Thread(NumAndLetterPrinter::printer, "numThread").start();
        new Thread(NumAndLetterPrinter::printer, "letterThread").start();
    }

    private static void printer() {
        synchronized (lock) {
            for (int i = 0; i < 26; i++) {
                if (Thread.currentThread().getName() == "numThread") {
                    // 打印数字1-26
                    System.out.println(i + 1);
                    // 唤醒其他在等待的线程
                    lock.notifyAll();
                    try {
                        // 让当前线程释放资源，进入wait状态
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else if (Thread.currentThread().getName() == "letterThread"){
                    // 打印字母A-Z
                    System.out.println((char)('A' + i));
                    // 唤醒其他在等待的线程
                    lock.notifyAll();

                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            // 唤醒主线程
            lock.notifyAll();
        }
    }
}
