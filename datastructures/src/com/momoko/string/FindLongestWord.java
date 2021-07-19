package com.momoko.string;

/**
 * Created by momoko on 2021/7/18.
 */
public class FindLongestWord {
    // 判断字符串source中是否可以通过删除几个字符包含target
    public static boolean containsWord(String source, String target) {
        int index = 0;
        int m = target.length();
        for (int i = 0; i < source.length(); i++) {
            if (source.charAt(i) == target.charAt(index)) {
                index++;
                if (index == m) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        boolean b = containsWord("abpcplea", "apple");
        System.out.println(b);
    }
}
