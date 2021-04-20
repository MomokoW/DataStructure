package com.momoko.recursion;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by momoko on 2021/4/10.
 */
public class Permute {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Permute permute = new Permute();
        permute.permute(nums);
    }

    List<List<Integer>> res = new LinkedList<>();
    int[] arr;
    public List<List<Integer>> permute(int[] nums) {
        arr = Arrays.copyOf(nums, nums.length);
        dfs(0);
        return res;
    }
    public void dfs(int x) {
        if (x == arr.length - 1) {
            List<Integer> resTmp = new LinkedList<>();
            for (int num : arr) {
                resTmp.add(num);
            }
            res.add(resTmp);
        }
        for (int i = x; i < arr.length; i++) {
            swap(i, x);   // 交换，将 c[i] 固定在第 x 位
            dfs(x + 1);   // 开始固定第 x + 1 位字符
            swap(i, x);   // 恢复交换
        }

    }
    public void swap(int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}