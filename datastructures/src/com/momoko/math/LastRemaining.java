package com.momoko.math;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by momoko on 2021/4/9.
 */
public class LastRemaining {
    public static void main(String[] args) {
        int num = lastRemaining(70866, 116922);
        System.out.println(num);
    }

    public static int lastRemaining(int n, int m) {
        //约瑟夫环问题
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            queue.add(i);
        }
        int count = 0;
        while (!queue.isEmpty()) {
            // 1.出队列
            Integer num = queue.poll();
            // 2.计数器++
            count++;
            // 判断
            if (count % m == 0 && queue.size() == 0) {
                return num;
            } else {
                queue.add(num);
            }
        }
        return 0;
    }
}