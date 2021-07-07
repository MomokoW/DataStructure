package com.momoko.greedy;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by momoko on 2021/7/3.
 */
public class MinFuelPrice {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int C = Integer.parseInt(sc.nextLine());
        int n = Integer.parseInt(sc.nextLine());
        int[] price = new int[n];
        int[] dis = new int[n];
        for (int i = 0; i < n; i++) {
            String str = sc.nextLine();
            String[] strs = str.split(",");
            price[i] = Integer.parseInt(strs[0]);
            dis[i] = Integer.parseInt(strs[1]);
        }

        Stack<Integer> price_stack = new Stack<>();
        Stack<Integer> mile_stack = new Stack<>();
        price_stack.push(price[n - 1]);
        mile_stack.push(dis[n - 1]);
        for (int i = n - 2; i >= 0; i--) {
            int temp = dis[i];
            while (!price_stack.isEmpty() && price[i] < price_stack.peek()) {
                if (mile_stack.peek() + temp <= C) {
                    price_stack.pop();
                    temp += mile_stack.pop();
                } else {
                    mile_stack.push(temp + mile_stack.pop() - C);
                    temp = C;
                    break;
                }
            }
            mile_stack.push(temp);
            price_stack.push(price[i]);
        }

        int count = 0;
        while (!price_stack.isEmpty()) {
            count += price_stack.pop() * mile_stack.pop();
        }
        System.out.println(count);
    }
}
