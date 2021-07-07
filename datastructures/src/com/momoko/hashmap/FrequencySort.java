package com.momoko.hashmap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Created by momoko on 2021/7/7.
 * 给定一个字符串，请将字符串里的字符按照出现的频率降序排列。
 *
 * 示例 1:
 * 输入:
 * "tree"
 *
 * 输出:
 * "eert"
 *
 * 解释:
 * 'e'出现两次，'r'和't'都只出现一次。
 * 因此'e'必须出现在'r'和't'之前。此外，"eetr"也是一个有效的答案。
 */
public class FrequencySort {
    public static void main(String[] args) {

    }

    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>((o1, o2) -> o1.freq == o2.freq ? o2.code - o1.code : o2.freq - o1.freq);
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            priorityQueue.offer(new Node(entry.getKey(), entry.getValue()));
        }
        StringBuilder sb = new StringBuilder();
        while (!priorityQueue.isEmpty()) {
            Node node = priorityQueue.poll();
            sb.append(String.valueOf(node.code).repeat(Math.max(0, node.freq)));
        }
        return sb.toString();
    }

}

class Node {
    public int freq;
    public char code;

    public Node(char code, int freq) {
        this.code = code;
        this.freq = freq;
    }
}
