package com.momoko.set;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by momoko on 2021/2/26.
 */
public class Subset {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> subsets = subsets(nums);
        subsets.forEach(System.out::println);
    }
    public static  List<List<Integer>> subsets(int[] nums) {
        //这题的思路还是使用位运算，用0，1表示元素在不在子集中，如果有三个元素，则有8中不同的位运算表示
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < (1 << nums.length); i++) {
            List<Integer> sub = new ArrayList<>();
            for (int j = 0; j < nums.length; j++) {
                if ((i & (1 << j)) != 0) {
                    sub.add(nums[j]);
                }
            }
            list.add(sub);
        }
        return list;
    }
} 