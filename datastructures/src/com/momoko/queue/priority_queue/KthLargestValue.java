package com.momoko.queue.priority_queue;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by momoko on 2021/5/19.
 */
public class KthLargestValue {

    public static int kthLargestValue(int[][] matrix, int k) {
        // 求出所有坐标的异或值，并存放到最大堆中
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(k, Comparator.naturalOrder());
        // 对数组求异或值
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i == 0 && j == 0) {
                    matrix[i][j] = matrix[i][j];
                } else if (i == 0) {
                    matrix[i][j] = matrix[i][j - 1] ^ matrix[i][j];
                } else if (j == 0) {
                    matrix[i][j] = matrix[i - 1][j] ^ matrix[i][j];
                } else {
                    matrix[i][j] = matrix[i - 1][j] ^ matrix[i][j - 1] ^ matrix[i][j] ^ matrix[i - 1][j - 1];
                }

                if (priorityQueue.size() < k) {
                    priorityQueue.offer(matrix[i][j]);
                } else {
                    if (matrix[i][j] > priorityQueue.peek()) {
                        priorityQueue.poll();
                        priorityQueue.offer(matrix[i][j]);
                    }
                }
            }
        }
        return priorityQueue.peek();
    }

    public static void main(String[] args) {
        int[][] arr = {{5, 2}, {1, 6}};
        kthLargestValue(arr,4);
    }
}