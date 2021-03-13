package com.momoko.hashset;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by momoko on 2021/3/13.
 * 不使用任何内建的哈希表库设计一个哈希集合（HashSet）。
 *
 * 实现 MyHashSet 类：
 *
 * void add(key) 向哈希集合中插入值 key 。
 * bool contains(key) 返回哈希集合中是否存在这个值 key 。
 * void remove(key) 将给定值 key 从哈希集合中删除。如果哈希集合中没有这个值，什么也不做。
 */

/**
 * 设哈希表的大小为 base，则可以设计一个简单的哈希函数：hash(x) = x mod base.
 *
 * 我们开辟一个大小为 base 的数组，数组的每个位置是一个链表。当计算出哈希值之后，就插入到对应位置的链表当中。
 *
 * 由于我们使用整数除法作为哈希函数，为了尽可能避免冲突，应当将 base 取为一个质数。在这里，取 base=769。
 *
 */
public class MyHashSet {
    //使用一个质数作为基数
    public static final int BASE = 769;
    private LinkedList[] data;

    /** Initialize your data structure here. */
    public MyHashSet() {
        //初始化链表
        data = new LinkedList[BASE];
        for (int i = 0; i < BASE; i++) {
            data[i] = new LinkedList<Integer>();
        }
    }

    public void add(int key) {
        //计算哈希值，看是否有冲突
        int h = hash(key);
        //计算出相同的哈希值，则判断两个数是否是相等的，不相等则将其插入到对应位置的链表尾部
        Iterator iterator = data[h].iterator();
        while (iterator.hasNext()) {
            Integer ele = (Integer) iterator.next();
            if (ele == key) {
                return;
            }
        }
        data[h].offerLast(key);
    }

    public void remove(int key) {
        //先查看是否有对应的值并找到对应位置的值
        int h = hash(key);
        Iterator iterator = data[h].iterator();
        while (iterator.hasNext()) {
            Integer ele = (Integer)iterator.next();
            if (ele == key) {
                data[h].remove(ele);
                return;
            }
        }
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        //先查看是否有对应的值并找到对应位置的值
        int h = hash(key);
        Iterator iterator = data[h].iterator();
        while (iterator.hasNext()) {
            Integer ele = (Integer)iterator.next();
            if (ele == key) {
                return true;
            }
        }
        return false;
    }

    //计算哈希值的函数
    private static int hash(int key) {
        return key % BASE;
    }
}