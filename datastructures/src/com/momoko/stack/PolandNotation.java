package com.momoko.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Created by momoko on 2021/2/7.
 */
public class PolandNotation {
    public static void main(String[] args) {
        //完成将中缀表达式转成后缀表达式的功能
        String expression = "1+(2+3)*4-5";
        List<String> list = toInfixExpressionList(expression);
        System.out.println(list);
        List<String> suffixExpression = parseSuffixExpressionList(list);
        System.out.println(suffixExpression);

        //计算后缀表达式的值
        int res = calculate(suffixExpression);
        System.out.printf("%s = %d",suffixExpression,res);


    }
    //将中缀表达式转成对应的list
    public static List<String> toInfixExpressionList(String s) {
        //定义List将中缀表达式字符串转为包含对应字符的List
        List<String> ls = new ArrayList<>();
        int i = 0;    //用于遍历中缀表达式字符串
        String str;   //对多位数的拼接操作
        char c;       //每遍历到一个字符就放入c
        do {
            if ((c = s.charAt(i)) < 48 || (c = s.charAt(i)) > 57) {
                ls.add("" + c);
                i++;
            } else {
                str = "";
                while (i < s.length() && (c = s.charAt(i)) >= 48 && (c = s.charAt(i)) <= 57 ) {
                    str += c;   //拼接多位数
                    i++;
                }
                ls.add(str);
            }
        } while (i < s.length());
        return ls;
    }

    //将一个逆波兰表达式，依次将数据和运算符放入到ArrayList中
    public static List<String> getListString(String suffixExpression) {
        //将后缀表达式加入到List中
        String[] split = suffixExpression.split(" ");
        List<String> list = new ArrayList<>(Arrays.asList(split));
        return list;
    }

    //完成对逆波兰表达式的计算
    /**
     * 从左至右扫描表达式，遇到数字则入栈
     * 遇到运算符则弹出栈顶和次栈顶元素，并完成运算，再将结果入栈
     * 如果为-运算符，则注意使用后弹出的数字减去先弹出的数字
     * 反复进行上面的步骤直到遍历完表达式
     * 此时栈中的元素为结果
     */
    public static int calculate(List<String> ls) {
        //创建一个栈存放数据
        Stack<String> stack = new Stack<>();
        for (String item : ls) {
            if (item.matches("\\d+")) {
                //匹配数字，入栈
                stack.push(item);
            } else {
                //取出栈顶元素和次顶元素进行计算
                int num1 = Integer.parseInt(stack.pop());
                int num2 = Integer.parseInt(stack.pop());
                int res = 0;
                switch(item) {
                    case "+":
                        res = num1 + num2;
                        break;
                    case "-":
                        res = num2 - num1;
                        break;
                    case "*":
                        res = num1 * num2;
                        break;
                    case "/":
                        res = num2 / num1;
                        break;
                    default:
                        throw new RuntimeException("非法的运算符");
                }
                stack.push(String.valueOf(res));
            }
        }
        return Integer.parseInt(stack.pop());
    }

    /**
     * 中缀表达式转后缀表达式
     * 步骤：
     * 1.初始化两个栈：运算符栈s1和储存中间结果的栈s2
     * 2.从左至右扫描中缀表达式
     * 3.遇到操作数时，将其压入s2
     * 4.遇到运算符时，比较其与s1栈顶运算符的优先级
     *   1)如果s1为空，或栈顶运算符为左括号"(",则直接将此运算符入栈
     *   2)若优先级比栈顶运算符的高，也将运算符压入s1
     *   3)否则，将s1栈顶的运算符弹出并压入到s2中，再次转到4.1与s2中新的栈顶运算符相比较
     * 5.遇到括号时：
     *   1)如果是左括号"("，则直接压入s1
     *   2)如果是右括号")"，则依次弹出s1栈顶的运算符，并压入s2，直到遇到括号为止，此时将这一对括号丢弃
     * 6.重复步骤2至5，直到表达式的最右边
     * 7.将s1中剩余的运算符依次弹出并压入s2
     * 8.依次弹出s2中的元素并输出，结果的逆序即为中缀表达式对应的后缀表达式
     * @param ls 中缀表达式的List
     * @return 后缀表达式的List
     */
   public static List<String> parseSuffixExpressionList(List<String> ls) {
       Stack<String> s1 = new Stack<>();
       List<String> s2 = new ArrayList<>();
       //遍历ls
       for (String item : ls) {
           if (item.matches("\\d+")) {
               s2.add(item);
           } else if (item.equals("(")) {
               s1.push(item);
           } else if (item.equals(")")) {
               while (!s1.peek().equals("(")) {
                   s2.add(s1.pop());
               }
               s1.pop();   //将左括号出栈
           } else {
               while (s1.size() != 0 && Operation.getValue(s1.peek()) >= Operation.getValue(item)) {
                   s2.add(s1.pop());
               }
               s1.push(item);
           }
       }
       while (!s1.isEmpty()) {
           s2.add(s1.pop());
       }
       return s2;
   }

}

class Operation {
    private static int ADD = 1;
    private static int SUB = 1;
    private static int MUL = 2;
    private static int DIV = 2;

    public static int getValue(String operation) {
        int result = 0;
        switch (operation){
            case "+":
                result = ADD;
                break;
            case "-":
                result = SUB;
                break;
            case "*":
                result = MUL;
                break;
            case "/":
                result = DIV;
                break;
            default:
                break;
        }
        return result;
    }
}
