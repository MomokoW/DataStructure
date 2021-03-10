package com.momoko.dfs;

import com.momoko.linkedlist.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by momoko on 2021/3/10.
 */
public class CanVisitAllRooms {
    public static void main(String[] args) {
        List<Integer> room0 = List.of(1, 3);
        List<Integer> room1 = List.of(3, 0, 1);
        List<Integer> room2 = List.of(2);
        List<Integer> romm3 = List.of(0);
        List<List<Integer>> rooms = List.of(room0, room1, room2, romm3);
        boolean b = canVisisAllRooms(rooms);
        System.out.println(b);
    }
    public static boolean canVisisAllRooms(List<List<Integer>> rooms) {
        int num = rooms.size();
        boolean[] visited = new boolean[num];
        Stack<Integer> stack = new Stack<>();
        //将0号房间入栈
        stack.push(0);
        visited[0] = true;
        int count = 1;
        while(!stack.isEmpty()) {
            int index = stack.pop();
            List<Integer> keys = rooms.get(index);
            if (!keys.isEmpty()) {
                //将未访问过的房间入栈
                for (Integer key : keys) {
                    if (!visited[key]) {
                        //入栈并置已访问标志
                        stack.push(key);
                        visited[key] = true;
                        count++;
                    }
                }
            }
        }
        //深度优先搜索完后，看是否还有未访问过的房间
//        for (boolean room : visited) {
//            if (!room) {
//                return false;
//            }
//        }
        return count == num;
    }
}