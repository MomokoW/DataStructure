package com.momoko.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by momoko on 2021/3/8.
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是回文。
 * 返回符合要求的 最少分割次数 。
 */
public class MinCut {

    boolean[][] f;
    List<List<String>> ret = new ArrayList<List<String>>();
    List<String> ans = new ArrayList<String>();
    int n;

    public static void main(String[] args) {
        MinCut minCut = new MinCut();
        int min = minCut.minCut("ab");
        System.out.println(min);
    }

    public List<List<String>> partition(String s) {
        n = s.length();
        f = new boolean[n][n];
        for (int i = 0; i < n; ++i) {
            Arrays.fill(f[i], true);
        }

        for (int i = n - 1; i >= 0; --i) {
            for (int j = i + 1; j < n; ++j) {
                f[i][j] = (s.charAt(i) == s.charAt(j)) && f[i + 1][j - 1];
            }
        }

        dfs(s, 0);
        return ret;
    }

    public void dfs(String s, int i) {
        if (i == n) {
            ret.add(new ArrayList<String>(ans));
            return;
        }
        for (int j = i; j < n; ++j) {
            if (f[i][j]) {
                ans.add(s.substring(i, j + 1));
                dfs(s, j + 1);
                ans.remove(ans.size() - 1);
            }
        }
    }
    public int minCut(String s) {
        //可以将所有分割情况得到的回文子串需要用到的分割次数记录下来
        List<List<String>> partition = partition(s);
        Stream<List<String>> stream = partition.stream();
        Integer min = stream.map(List::size).min((o1, o2) -> o1 - o2).orElse(0);
        return min - 1;
    }
}