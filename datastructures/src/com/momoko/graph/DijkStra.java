package com.momoko.graph;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by momoko on 2021/6/18.
 * 迪杰斯特拉算法，单源最短路径问题
 */
public class DijkStra {
    static final int MAX = Integer.MAX_VALUE;
    public static void main(String[] args) {
        // 构建有向图，得到矩阵
        int[][] weight = {
                {0,3,MAX,MAX,30},
                {MAX,0,25,8,MAX},
                {MAX,MAX,0,MAX,10},
                {20,MAX,4,0,12},
                {5,MAX,MAX,MAX,0}
        };
        int start = 1;
        int[] dijsktra = dijsktra(weight,start);
    }

    public static int[] dijsktra(int[][] weight, int start) {
        int length = weight.length;
        // 存放到各个点的最短路径的长度
        int[] dist = new int[length];
        for (int i = 0; i < length; i++) {
            dist[i] = weight[start][i];
        }
        // 存放到各个点的最短路径
        int[] path = new int[length];
        // 标记数组，标记目标点到某个点的最短路径是否已经找到了
        int[] mark = new int[length];
        int min, k;
        mark[start] = 1;
        Arrays.fill(path, start);
        do {
            k = start;
            min = Integer.MAX_VALUE;
            // 找最短路径，每次循环都找最短的路径
            for (int i = 0; i < length; i++) {
                if (mark[i] == 0 && dist[i] < min) {
                    min = dist[i];
                    k = i;
                }
            }
            if (k != start) {
                mark[k] = 1;
                // 更改到其他点的最短路径，即通过最短路径来找次短路径
                for (int i = 0; i < length; i++) {
                    if (weight[k][i] < Integer.MAX_VALUE && dist[i] > min + weight[k][i]) {
                        dist[i] = min + weight[k][i];
                        path[i] = k;
                    }
                }
            }
        } while (k != start);

        // 输出各最短路径
        for (int i = 0; i < length; i++) {
            if (i != start && dist[i] < Integer.MAX_VALUE) {
                k = i;
                do {
                    System.out.print(k + "<-");
                    k = path[k];
                } while (k != start);
            }
            System.out.println(start);
            System.out.println(dist[i]);
        }
        return dist;
    }
}
