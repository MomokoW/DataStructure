package com.momoko.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by momoko on 2021/2/9.
 * 1)第一个皇后先放第一行第一列
 * 2)第二个皇后放在第二行第一列、然后判断是否OK，如果不OK，继续放在第二列、第三列、依次把所有列都
 * 放完，找到一个合适
 * 3) 继续第三个皇后，还是第一列、第二列……直到第8个皇后也能放在一个不冲突的位置，算是找到了一个正确
 * 解
 * 4)当得到一个正确解时，在栈回退到上一个栈时，就会开始回溯，即将第一个皇后，放到第一列的所有正确解，
 * 全部得到.
 * 5)然后回头继续第一个皇后放第二列，后面继续循环执行1.2,3,4的步骤
 */
public class Queue8 {
    //定义一个max表示共有多少个皇后
    int max = 4;
    //定义数组array，保存皇后放置位置的结果，比如arr = {0, 4, 7, 5, 2, 6, 1, 3}
    int[] array = new int[max];
    char[][] arr = new char[max][max];
    static int count = 0;
    static List<List<String>> list = new ArrayList<>();
    public static void main(String[] args) {
        Queue8 queue8 = new Queue8();
        queue8.check(0);
        System.out.println(list);
    }

    //放置第n个皇后
    private void check(int n) {
        if (n == max) {  //n = 8,其实8个皇后都被放好了
            print();
            return;
        }
        //依次放入皇后，并判断是否冲突
        for(int i = 0; i < max; i++) {
            //先把当前这个皇后n，放到该行的第一列
            array[n] = i;
            //判断当放置第n个皇后放在第i列时，是否产生冲突
            if (judge(n)) {  //不冲突
                //接着放第n+1个皇后
                check(n + 1);
            }
            //如果冲突，就继续执行array[n] = i,即将第n个皇后后移
        }
    }

    //查看当我们放置第n个皇后，就去检测该皇后是否和前面已经摆放的皇后冲突
    private boolean judge(int n) {
        for (int i = 0; i < n; i++) {
            //array[i] == array[n]表示判断第n个皇后是否和第i个皇后在同一列
            //Math.abs(n - i) == Math.abs(array[n] - array[i])表示判断第n个皇后是否和第i个皇后在同一对角线上
            if (array[i] == array[n] || Math.abs(n - i) == Math.abs(array[n] - array[i])) {
                return false;
            }
        }
        return true;
    }

    //将皇后摆放的位置输出
    private void print() {
//        for (int i = 0; i < array.length; i++) {
//            System.out.print(array[i] + " ");
//        }
//        System.out.println();
//        count++;
        for (char[] value : arr) {
            Arrays.fill(value, '.');
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i][array[i]] = 'Q';
        }
        List<String> ls = new ArrayList<>();
        for (char[] chars : arr) {
            ls.add(String.valueOf(chars));
        }
        list.add(ls);

    }
}