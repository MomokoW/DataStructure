package com.momoko.graph;

import java.util.Arrays;

/**
 * Created by momoko on 2021/8/3.
 * 有 n 个网络节点，标记为1到 n。
 * 给你一个列表times，表示信号经过 有向 边的传递时间。times[i] = (ui, vi, wi)，其中ui是源节点，vi是目标节点， wi是一个信号从源节点传递到目标节点的时间。
 * 现在，从某个节点K发出一个信号。需要多久才能使所有节点都收到信号？如果不能使所有节点收到信号，返回-1 。
 */
public class NetDelayTime {
    public static void main(String[] args) {
        int[][] times = {{2,1,1}, {2,3,1}, {3,4,1}};
        int time = networkDelayTime(times, 4, 2);
        System.out.println(time);

    }

    public static int networkDelayTime(int[][] times, int n, int k) {
        // 使用Dijstra算法求单源最短路径
        // 先建立有向图
        int[][] weight = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(weight[i], Integer.MAX_VALUE);
            weight[i][i] = 0;
        }
        for (int i = 0; i < times.length; i++) {
            weight[times[i][0] - 1][times[i][1] - 1] = times[i][2];
        }
        // 存放源点到各个点的最短路径的长度
        int[] dist = new int[n];
        // 最开始长度就是该点到其他点的长度
        for (int i = 0; i < n; i++) {
            dist[i] = weight[k - 1][i];
        }
        // 标记数组，标记目标点到某个点的最短路径是否已经找到了
        int[] mark = new int[n];
        mark[k - 1] = 1;
        int min, temp;
        do {
            temp = k - 1;
            min = Integer.MAX_VALUE;
            // 找最短路径，每次循环都找最短的路径
            for (int i = 0; i < n; i++) {
                if (mark[i] == 0 && dist[i] < min) {
                    min = dist[i];
                    temp = i;
                }
            }
            if (temp != k - 1) {
                mark[temp] = 1;
                // 更改到其他点的最短路径，即通过最短路径来找次短路径
                for (int i = 0; i < n; i++) {
                    if (weight[temp][i] < Integer.MAX_VALUE && dist[i] > min + weight[temp][i]) {
                        dist[i] = min + weight[temp][i];
                    }
                }
            }
        } while (temp != k - 1);

        int res = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
                res = Math.max(dist[i], res);
        }
        if (res == Integer.MAX_VALUE) {
            return -1;
        }
        return res;
    }
}
