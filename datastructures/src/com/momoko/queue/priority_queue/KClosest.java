package com.momoko.queue.priority_queue;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by momoko on 2021/4/26.
 */
public class KClosest {

    public static int[][] kClosest(int[][] points, int k) {
        // 使用最大堆存储元素
        Queue<int[]> Q= new PriorityQueue<>((a, b) ->b[0] * b[0] + b[1] * b[1] - a[0] * a[0] + a[1] * a[1]);

        for (int[] point : points) {
            if (Q.size() < k) {
                Q.offer(point);
            } else {
                int[] pos = Q.peek();
                double dis1 = Math.sqrt(pos[0] * pos[0] + pos[1] * pos[1]);
                double dis2 = Math.sqrt(point[0] * point[0] + point[1] * point[1]);
                if (dis2 < dis1) {
                    Q.poll();
                    Q.offer(point);
                }
            }
        }
        // 将所有的点出队
        int[][] res = new int[Q.size()][];
        int i = 0;
        while (!Q.isEmpty()) {
            res[i++] = Q.poll();
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] points = {{3,3}, {5,-1}, {-2,4}};
        kClosest(points, 2);
    }
}