package com.momoko.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by momoko on 2021/3/1.
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 */
public class YangHuiTria {
    public List<List<Integer>> generate(int numRows) {
        //1.声明并初始化返回的List
        List<List<Integer>> result = new ArrayList<>();

        //2.给数组的元素赋值
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    row.add(result.get(i - 1).get(j - 1) + result.get(i - 1).get(j));
                }
            }
            result.add(row);
        }
//        //3/遍历
//        for (int i = 0; i < yanghui.length; i++) {
//            List<Integer> list = new ArrayList<>();
//            for (int j = 0; j < yanghui[i].length; j++) {
//                    list.add(yanghui[i][j]);
//            }
//            result.add(list);
//        }
        return result;
    }
}