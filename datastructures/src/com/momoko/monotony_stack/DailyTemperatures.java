package com.momoko.monotony_stack;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by momoko on 2021/3/6.
 * 请根据每日 气温 列表，重新生成一个列表。对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 *
 * 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
 *
 */
public class DailyTemperatures {

    public int[] dailyTemperatures(int[] T) {
   /*
   使用单调栈来解决，单调栈维护存储下标，从栈底到栈顶的下标对应的温度列表中的温度依次递减，
   如果 一个下标在单调栈里，则表示未找到下一次温度更高的下标
   正向遍历温度列表。对于温度列表中的每个元素 T[i]，如果栈为空，则直接将 i 进栈
   如果栈不为空，则比较栈顶元素 prevIndex 对应的温度 T[prevIndex] 和当前温度 T[i]
   如果 T[i] > T[prevIndex]，则将 prevIndex 移除，并将 prevIndex 对应的等待天数赋为 i - prevIndex
   重复上述操作直到栈为空或者栈顶元素对应的温度小于等于当前温度，然后将 i 进栈。
    */
        int len = T.length;
        int[] ans = new int[len];
        Arrays.fill(ans, 0);
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            int temperature = T[i];
            while (!stack.isEmpty() && temperature > T[stack.peek()]) {
                int prevIndex = stack.pop();
                ans[prevIndex] = i - prevIndex;
            }
            stack.push(i);
        }
        return ans;

    }
}