package com.momoko.linkedlist;

import java.util.List;

/**
 * Created by momoko on 2021/3/5.
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }


}