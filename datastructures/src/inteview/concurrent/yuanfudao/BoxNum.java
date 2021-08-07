package inteview.concurrent.yuanfudao;

import java.util.Stack;

/**
 * Created by momoko on 2021/7/31.
 * 箱子数量[]代表一个箱子，[]2代表两个箱子，[[]2]2代表6个箱子，表示有两个大箱子，每个大箱子中间装了2个小箱子，共6个箱子
 */
public class BoxNum {

    public static int boxNum(String boxes) {
        // 遇到左括号就相加，遇到右括号就+1，遇到数字就相乘
        Stack<String> stack = new Stack<>();
        int res = 0;
        int i = 0;
        int N = boxes.length();
        while (i < N) {
            char ch = boxes.charAt(i);
            if (ch == '[') {
                stack.push(ch + "");
                i++;
            } else if (ch == ']') {
                // pop到第一个左括号，然后把对应的数字push进栈
                int count = 1;
                while (!stack.empty() && !stack.peek().equals("[")) {
                    // 计算中间所有数值
                    count += Integer.parseInt(stack.pop());
                }
                // 弹出左括号
                stack.pop();
                if (i < N - 1 && Character.isDigit(boxes.charAt(i + 1))) {
                    count *= Integer.parseInt(String.valueOf(boxes.charAt(i + 1)));
                    i += 2;
                } else {
                    i++;
                }
                stack.push(count + "");
            }
        }
        // 把结果计算出来
        while (!stack.empty() && !stack.peek().equals("[")) {
            // 计算中间所有数值
            res += Integer.parseInt(stack.pop());
        }
        return res;
    }

    public static void main(String[] args) {
//        String boxed = "[][[][][]2]3";
//        String boxed = "[][][[[]3[]2]2]2";
        String boxed = "[[]2]2";
        int res = boxNum(boxed);
        System.out.println(res);
    }
}
