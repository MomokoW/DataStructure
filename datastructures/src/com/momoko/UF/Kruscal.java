package com.momoko.UF;

import com.momoko.heap.Array;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by momoko on 2021/7/22.
 * 【题目】给定一个图的点集，边集和权重，返回构建最小生成树的代价。
 *
 * 输入：N = 2， conn = [[1, 2, 37], [2, 1, 17], [1, 2, 68]]
 *
 * 输出：17
 */
public class Kruscal {
    private long cost;

    private int[] F;

    // 初始化并查集
    private void init(int n) {
        F = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            // 每个人自成一派，是自己帮的帮主
            F[i] = i;
        }
        cost = 0;
    }

    // 查找每个集合的老大
    private int find(int x) {
        if (x == F[x]) {
            return x;
        }
        F[x] = find(F[x]);
        return F[x];
    }

    // 将两个集合并称一个，并加上对应的权重
    private void union(int x, int y, int pay) {
        if (find(x) != find(y)) {
            cost += pay;
        }
        F[find(x)] = find(y);
    }

    // n个顶点，m条边的顶点偶对，生成最小生成树
    public long kruscal(int n, int m, int[][] conn) {
        // 初始化集合
        init(n);
        // 将所有的边集进行排序
        Arrays.sort(conn, Comparator.comparingInt(o -> o[2]));
        // 顺序地将边添加到集合中
        for (int i = 0; i < m; i++) {
            union(conn[i][0], conn[i][1], conn[i][2]);
        }
        return cost;
    }

    public void print() {
        for (int i = 0; i < F.length; i++) {
            System.out.printf("F[%d] = %d\n", i, F[i]);
        }
    }

    public static void main(String[] args) {
        int[][] conn = {{1, 5, 4}, {2, 3, 5}, {2, 4, 8}, {3, 4, 10}, {2, 6, 12}, {4, 6, 15},
                {1, 2, 18}, {4, 5, 20}, {1, 6, 23}, {5, 6, 25}};

        Kruscal kruscal = new Kruscal();
        long res = kruscal.kruscal(6, 10, conn);
        System.out.println(res);
        kruscal.print();

    }

}
