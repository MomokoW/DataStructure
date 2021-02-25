package com.momoko.learn_string;

/**
 * Created by momoko on 2021/2/25.
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 *
 * 说明：
 *
 * 无空格字符构成一个 单词 。
 * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 *
 * 输入："  hello world!  "
 * 输出："world! hello"
 * 解释：输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 *
 * 输入："a good   example"
 * 输出："example good a"
 * 解释：如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 *
 * 输入：s = "  Bob    Loves  Alice   "
 * 输出："Alice Loves Bob"
 */
public class ReverseWords {

    public static void main(String[] args) {
        String s = "Alice does not even like bob";
        String s2 = s.trim();
        String[] split = s2.split("\\s+");
        for (String s1 : split) {
            System.out.println(s1);
        }

        String s1 = reverseWords(s);
        System.out.println(s1);

    }
    public static String reverseWords(String s) {
        String trim = s.trim();
        String[] split = trim.split("\\s+");
        String temp = "";
        //注意，以后交换，尽量用双指针来做，高级一点
        for (int i = 0; i < split.length / 2; i++) {
            temp = split[i];
            split[i] = split[split.length - 1 - i];
            split[split.length - 1 - i] = temp;
        }
        String rs = "";
        for (int i = 0; i < split.length; i++) {
            rs += split[i];
            if (i != split.length - 1) {
                rs += " ";
            }

        }
        return rs;
    }
}