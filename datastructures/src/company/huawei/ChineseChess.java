package company.huawei;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by momoko on 2021/7/7.
 * 给定一张棋盘，棋盘上的棋子有三种类型，马的起始位置，马要到达的目标位置和其他的棋子
 * 其他的棋子可能会阻碍马的前进路线，限制条件如下：
 * 1.马走日的路径上不能被绊马脚
 * 2.马不能到达有棋子的位置
 * 计算到达目标位置至少要走多少步，如果不能到达输出-1
 * 马每次跳跃最多可以有八个方向，但是如果前进方向有棋子，则会被绊马脚。
 * 输入第一行表示棋盘的宽和长，用空格分开
 * 输入 . 表示没有棋子，输入#表示有棋子，H表示马当前位置，T表示马要到达的位置。
 */
public class ChineseChess {
    static int[][] directions = {{-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();
        sc.nextLine();  // 回车
        char[][] data = new char[row][col];
        int[] h = new int[2];
        int[] t = new int[2];
        for (int i = 0; i < row; i++) {
            String temp = sc.nextLine();
            for (int j = 0; j < col; j++) {
                data[i][j] = temp.charAt(j);
                if (data[i][j] == 'H') {
                    h[0] = i;
                    h[1] = j;
                } else if (data[i][j] == 'T') {
                    t[0] = i;
                    t[1] = j;
                }
            }
        }
        if (h[0] == t[0] && h[1] == t[1]) {
            System.out.println(0);
            return;
        }
        boolean[][] visited = new boolean[row][col];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(h);
        visited[h[0]][h[1]] = true;
        int step = 0;
        while (!queue.isEmpty()) {
            int cur = queue.size();
            for (int i = 0; i < cur; i++) {
                int[] xy = queue.poll();
                for (int[] direction : directions) {
                    int curX = xy[0] + direction[0];
                    int curY = xy[1] + direction[1];
                    // 看看有没有绊马腿的点
                    int xx = xy[0] + direction[0] / 2;
                    int yy = xy[1] + direction[1] / 2;
                    if (curX < 0 || curX >= row || curY < 0 || curY >= col || data[curX][curY] == '#' || data[xx][yy]=='#' || visited[curX][curY]) {
                        continue;
                    }
                    if (curX == t[0] && curY == t[1]) {
                        System.out.println(step + 1);
                        return;
                    }
                    queue.add(new int[]{curX, curY});
                    visited[curX][curY] = true;
                }
            }
            step++;
        }
        System.out.println(-1);
    }
}
