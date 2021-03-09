package com.momoko.stack;

import java.util.Stack;

/**
 * Created by momoko on 2021/3/9.
 */
public class DecodeString {
    public static void main(String[] args) {
        String s = "abc3[cd]xyz";
        String s1 = decodeString(s);
        System.out.println(s1);
    }

    public static String decodeString(String s) {
        Stack<String> strStack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();
        Stack<String> tempStack = new Stack<>();
        String keepNum = ""; //用于处理多位数
        char ch = ' ';
        int index = 0;
        while (true) {
            //依次判断得到的每一个字符
            ch = s.charAt(index);
            //判断ch是什么，然后做相应的处理
            if (!Character.isDigit(ch)) {
                if (ch != ']') {
                    strStack.push(String.valueOf(ch));
                } else {
                    //遇到 ] 则进行复制弹出操作，弹出的字符串序列需要先逆序一下
                    StringBuilder str = new StringBuilder();
                    while (!strStack.peek().equals("[")) {
                        tempStack.push(strStack.pop());
                    }
                    strStack.pop();
                    while (!tempStack.isEmpty()) {
                        str.append(tempStack.pop());
                    }
                    //弹出数栈中的数字
                    int count = numStack.pop();
                    StringBuilder dupStr = new StringBuilder();
                    while (count > 0) {
                        dupStr.append(str);
                        count--;
                    }
                    //将新的字符串放到字符串栈中
                    strStack.push(dupStr.toString());
                }
            } else {
                //如果是数字，则需要判断下一个数是否也是数字
                keepNum += ch;

                if (s.charAt(index + 1) == '[') {
                    //如果是操作符，则入栈
                    numStack.push(Integer.parseInt(keepNum));
                    keepNum = "";
                }

            }
            //让index + 1，并判断是否扫描到expression最后
            index++;
            if (index >= s.length()) {
                break;
            }
        }

        //弹出字符串中的字符
        StringBuilder temp = new StringBuilder();
        while (!strStack.isEmpty()) {
            tempStack.push(strStack.pop());
        }
        while (!tempStack.isEmpty()) {
            temp.append(tempStack.pop());
        }
        return temp.toString();
    }
}