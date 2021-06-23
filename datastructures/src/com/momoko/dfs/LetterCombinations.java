package com.momoko.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by momoko on 2021/6/19.
 */
public class LetterCombinations {
    // 对应数字盘上的字母
    static String[] ds = new String[] {"", "", "abc", "def", "ghi", "jkl",
            "mno", "pqrs", "tuv", "wxyz"};
    public static List<String> letterCombinations(String digits) {
        int N = digits.length();
        if (N == 0) {
            return new ArrayList<String>();
        }
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        backtrace(digits, 0, sb, ans);
        return ans;
    }

    public static void backtrace(String digits, int i, StringBuilder box, List<String> ans) {
        int N = digits.length();
        // 长度已经达到了要求
        if (N == box.length()) {
            ans.add(box.toString());
        }
        // 超出长度的部分就不用处理了
        if (i >= N) {
            return;
        }
        // 遍历第i个人可以选择的宝石选项
        int index = (int)(digits.charAt(i) - '0');
        for (int idx = 0; idx < ds[index].length(); idx++) {
            // 放第index个人的第 idx 个宝石选项
            char ch = ds[index].charAt(idx);
            box.append(ch);
            // 开始处理第 i + 1个人
            backtrace(digits, i + 1, box, ans);
            // 把第index个人的第 i 个宝石拿出来
            box.delete(box.length() - 1, box.length());
        }
    }

    public static void main(String[] args) {
        String s = "23";
        List<String> strings = letterCombinations(s);
        strings.forEach(System.out::println);
    }

}
