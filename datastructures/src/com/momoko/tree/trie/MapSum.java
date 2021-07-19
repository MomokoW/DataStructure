package com.momoko.tree.trie;

/**
 * Created by momoko on 2021/7/18.
 */
public class MapSum {

    private class Node {
        public int value;
        public Node[] links;
        public Node(int value) {
            this.value = value;
            links = new Node[26];
        }
        public Node() {
            this(0);
        }
    }

    private Node root;

    /** Initialize your data structure here. */
    public MapSum() {
        root = new Node();
    }

    public void insert(String key, int val) {
        Node cur = root;
        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            if (cur.links[c - 'a'] == null) {
                cur.links[c - 'a'] = new Node();
            }
            cur = cur.links[c - 'a'];
        }
        cur.value = val;
    }

    public int sum(String prefix) {
        Node cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (cur.links[c - 'a'] == null) {
                return 0;
            }
            cur = cur.links[c - 'a'];
        }
        return sum(cur);
    }

    // 遍历Node以及Node的所有子树，将其下面word节点的值相加返回
    private int sum(Node node) {
        int res = node.value;
        for (int i = 0; i < node.links.length; i++) {
            res += sum(node.links[i]);
        }
        return res;
    }
}
