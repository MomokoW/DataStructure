package com.momoko.learn_string;

/**
 * Created by momoko on 2021/2/25.
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 */
public class LongestPalindrome {

    //中心扩散方法
    public String longestPalindrome(String s) {
        if (s.length() < 2) {
            return s;
        }

        return s;
    }

    //暴力求解，求出字符串的所有字串，再逐一判断是否是回文串
    public String method1(String s) {
        if (s.length() < 2) {
            return s;
        }
        int start = 0;
        int maxLen = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            for (int j = 0; j < s.length(); j++) {
                if (j - i < maxLen)
                    continue;
                if (isPalindrome(s, i, j)) {
                    if (maxLen < j - i + 1) {
                        start = i;
                        maxLen = j - i + 1;
                    }
                }
            }
        }
        return s.substring(start, start + maxLen);
    }

    public boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--))
                return false;
        }
        return true;
    }

    //动态规划法
    /*
    定义二维数组dp[length][length]，如果dp[left][right]为true，则表示字符串从left到right是回文子串，如果dp[left][right]为false，则表示字符串从left到right不是回文子串。
    如果dp[left+1][right-1]为true，我们判断s.charAt(left)和s.charAt(right)是否相等，如果相等，那么dp[left][right]肯定也是回文子串，否则dp[left][right]一定不是回文子串。
    递推公式：
    dp[left][right]=s.charAt(left)==s.charAt(right)&&dp[left+1][right-1]
    边界条件：
    如果s.charAt(left)==s.charAt(right)，字符串从left到right能不能构成回文子串还需要进一步判断

    如果left==right，也就是说只有一个字符，我们认为他是回文子串。即dp[left][right]=true（left==right）
    如果right-left<=2，类似于"aa"，或者"aba"，我们认为他是回文子串。即dp[left][right]=true（right-left<=2）
    如果right-left>2，我们只需要判断dp[left+1][right-1]是否是回文子串，才能确定dp[left][right]是否为true还是false。即dp[left][right]=dp[left+1][right-1]

     */
    public String method2(String s) {
        if (s.length() < 2) {
            return s;
        }
        int start = 0,maxLen = 1;
        int length = s.length();
        boolean[][] dp = new boolean[length][length];

        for (int right = 1; right < length; right++) {
            for (int left = 0; left < right; left++) {
                if (s.charAt(left) != s.charAt(right)) {
                    continue;
                }
                if (right == left) {
                    dp[left][right] = true;
                } else if (right - left <= 2) {
                    dp[left][right] = true;
                } else {
                    dp[left][right] = dp[left + 1][right - 1];
                }

                if (dp[left][right] && right - left + 1 > maxLen) {
                    maxLen = right - left + 1;
                    start = left;
                }
            }
        }

        return s.substring(start, start + maxLen);
    }
}