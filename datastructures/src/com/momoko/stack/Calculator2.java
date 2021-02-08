package com.momoko.stack;

/**
 * Created by momoko on 2021/2/6.
 * 中缀表达式的计算
 * 只能接收正常的输入，暂时没有加入检测功能
 * 加入括号的中缀表达式计算
 * 思路：括号的优先级最高，遇到右括号则计算到左括号为止
 */

public class Calculator2 {
    public static void main(String[] args) {
        //完成计算器操作
        String expression = "5*(83-3)+4/2";
        //创建两个栈，一个数栈，一个符号栈
        ArrayStack3 numStack = new ArrayStack3(10);
        ArrayStack3 operStack = new ArrayStack3(10);
        //定义需要的相关变量
        int index = 0;
        int num1 = 0;
        int num2 = 0;
        int oper = 0;
        int res = 0;
        char ch = ' '; //将每次扫描到char保存到ch
        String keepNum = "";  //用于处理多位数
        while (true) {
            //依次得到expression的每一个字符
            ch = expression.charAt(index);
            //判断ch是什么，然后做相应的处理
            if (operStack.isOper(ch)) {
                //判断当前的符号栈是否为空
                if (!operStack.isEmpty()) {
                    //判断是否为左括号或者右括号
                    if (ch == '(') {
                        operStack.push(ch);
                    } else if (ch == ')') {
                        //如果为右括号，则循环计算到第一个左括号为止
                        while((oper = operStack.pop()) != '(') {
                            num1 = numStack.pop();
                            num2 = numStack.pop();
                            res = numStack.cal(num1, num2, oper);
                            //把运算的结果push进数栈
                            numStack.push(res);
                        }
                    } else { //不为左右括号，则需要计算除去括号以外的优先级
                        //如果符号栈不为空则需要判断栈顶符号和当前符号的优先级（除去左括号，如果为左括号则直接入栈）
                        int top = operStack.peek();
                        if (top == '(') {
                            operStack.push(ch);
                        } else {
                            if (operStack.priority(ch) <= operStack.priority(top)) {
                                //1.如果当前符号的优先级小于或等于栈顶符号的优先级，则从符号栈中取出栈顶符号，数据栈中取出两个数进行运算，将运算结果存入数栈，当前符号入符号栈
                                oper = operStack.pop();
                                num1 = numStack.pop();
                                num2 = numStack.pop();
                                res = numStack.cal(num1, num2, oper);
                                //把运算的结果push进数栈
                                numStack.push(res);
                                //当前符号入符号栈
                                operStack.push(ch);
                            } else {
                                //2.如果当前符号的优先级大于栈顶符号的优先级，则直接入栈
                                operStack.push(ch);
                            }
                        }
                    }
                } else {
                    //如果符号栈为空则入栈
                    operStack.push(ch);
                }
            } else {
                //处理多位数，需要向后再看一位，如果是数，则继续扫描，如果是符号则直接入栈
                keepNum += ch;
                //如果ch已经是expression的最后一位，就直接入栈
                if (index == expression.length() - 1) {
                    numStack.push(Integer.parseInt(keepNum));
                } else {
                    //判断下一个字符是不是操作符
                    if (operStack.isOper(expression.charAt(index + 1))) {
                        //如果是操作符，则入栈
                        numStack.push(Integer.parseInt(keepNum));
                        keepNum = "";
                    }
                }
            }
            //让index + 1，并判断是否扫描到expression最后
            index++;
            if (index >= expression.length()) {
                break;
            }
        }

        //当表达式扫描完毕，就顺序从数栈和符号栈中pop出相应的数和符号，并运算
        while (true) {
            //如果符号栈为空，则计算到了最后的结果，数栈中只有一个数字结果
            if (operStack.isEmpty()) {
                break;
            }
            oper = operStack.pop();
            num1 = numStack.pop();
            num2 = numStack.pop();
            res = numStack.cal(num1, num2, oper);
            //把运算的结果push进数栈
            numStack.push(res);
        }
        System.out.printf("表达式 %s = %d",expression,numStack.pop());

    }
}

class ArrayStack3 {
    private int maxSize;   //栈的大小
    private int[] stack;   //数组模拟栈
    private int top = -1;  //top表示栈顶

    public ArrayStack3(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    //判断是否栈满
    public boolean isFull() {
        return top == maxSize - 1;
    }

    //栈空
    public boolean isEmpty() {
        return top == -1;
    }

    //入栈
    public void push(int value) {
        //先判断栈是否满
        if (isFull()) {
            System.out.println("栈已经满了");
            return;
        }
        stack[++top] = value;
    }

    //出栈
    public int pop() {
        //先判断是否栈空
        if (isEmpty()) {
            throw new RuntimeException("栈空，没有数据");
        }
        return stack[top--];
    }

    //遍历栈
    public void list() {
        if (isEmpty()) {
            System.out.println("栈空，没有数据");
        }
        for (int i = top; i >= 0; i--) {
            System.out.println(stack[i]);
        }
    }
    //查看栈顶

    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("栈空，没有数据");
        }
        return stack[top];
    }

    //数字越大，则优先级就越高
    public int priority(int oper) {
        if (oper == '*' || oper == '/') {
            return 1;
        } else if (oper == '+' || oper == '-') {
            return 0;
        } else {
            return -1;
        }
    }

    //判断是否为(
    public boolean isLeftBracket(char val) {
        return val == '(';
    }
    //判断是不是一个运算符
    public boolean isOper(char val) {
        return val == '+' || val == '-' || val == '*' || val == '/' || val == '(' || val == ')';
    }
    //计算方法
    public int cal(int num1, int num2, int oper) {
        int res = 0;
        switch (oper) {
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num2 - num1;
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                res = num2 / num1;
                break;
            default:
                break;
        }
        return res;
    }
}




