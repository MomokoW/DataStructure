package com.momoko.recursion;

/**
 * Created by momoko on 2021/2/9.
 */
public class MiGong {
    public static void main(String[] args) {
        //先创建一个二维数组，模拟迷宫
        int[][] map  = new int[8][7];
        //使用1表示墙
        //上下全置为1
        for (int i = 0; i < 6; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }
        //左右全置为1
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }
        map[3][1] = map[3][2] = 1;

        //输出地图
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

        //使用递归回溯给小球找路
        setWay(map,1 , 1);

        //输出新的地图
        //输出地图
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * 使用地递归回溯来给小球找路，结束点为地图右下角，本题为map[6][5]
     * 当map[i][j]为0时表示该点没有走过，为1时表示墙，2表示通路可以走，3表示该点已经走过，但是走不通
     * 在走迷宫时，需要确定一个策略，当前策略：下->右->上->左，如果走不通，再回溯
     * @param map 表示地图
     * @param i 从哪个位置开始找
     * @param j 从哪个位置开始找
     * @return 如果找到通路，就返回true，否则返回false
     */
    public static boolean setWay(int[][] map, int i, int j) {
        if (map[6][5] == 2) {  //通路已经找到ok
            return true;
        } else {
            if (map[i][j] == 0) {  //当前这个点还没有走过
                //按照策略走
                map[i][j] = 2;   //假定该点是可以走通的
                if (setWay(map, i + 1, j)) { //向下走
                    return true;
                } else if (setWay(map, i, j + 1)) { //向右走
                    return true;
                } else if (setWay(map, i - 1, j)) { //向上走
                    return true;
                } else if (setWay(map, i, j -1)) {  //向左走
                    return true;
                } else {   //说明该点走不通，是思路
                    map[i][j] = 3;
                    return false;
                }

            } else {
                return false;
            }
        }
    }
}