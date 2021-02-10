package com.momoko.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by momoko on 2021/2/9.
 */
public class EnhancedQueen {
    public static void main(String[] args) {
        EnhancedQueen queen = new EnhancedQueen();
        List<List<String>> lists = queen.solveNQueens(1);
        System.out.println(lists);
    }
    static List<List<String>> list = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        int[] array = new int[n];
        check(0,n,array);
        return list;

    }
    //放置第n个皇后
    private void check(int n,int max, int[] array) {
        if (n == max) {  //n = 8,其实8个皇后都被放好了
            print(max, array);
            return;
        }
        //依次放入皇后，并判断是否冲突
        for(int i = 0; i < max; i++) {
            //先把当前这个皇后n，放到该行的第一列
            array[n] = i;
            //判断当放置第n个皇后放在第i列时，是否产生冲突
            if (jude(n, array)) {  //不冲突
                //接着放第n+1个皇后
                check(n + 1, max, array);
            }
            //如果冲突，就继续执行array[n] = i,即将第n个皇后后移
        }
    }



    //查看当我们放置第n个皇后，就去检测该皇后是否和前面已经摆放的皇后冲突
    private boolean jude(int n, int[] array) {
        for (int i = 0; i < n; i++) {
            if (array[i] == array[n] || Math.abs(n - i) == Math.abs(array[n] - array[i])) {
                return false;
            }
        }
        return true;
    }

    //将皇后摆放的位置输出
    private void print(int max, int[] array) {
        char[][] arr = new char[max][max];
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