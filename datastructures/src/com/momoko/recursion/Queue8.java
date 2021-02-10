package com.momoko.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Created by momoko on 2021/2/9.
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
            if (jude(n)) {  //不冲突
                //接着放第n+1个皇后
                check(n + 1);
            }
            //如果冲突，就继续执行array[n] = i,即将第n个皇后后移
        }
    }

    //查看当我们放置第n个皇后，就去检测该皇后是否和前面已经摆放的皇后冲突
    private boolean jude(int n) {
        for (int i = 0; i < n; i++) {
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