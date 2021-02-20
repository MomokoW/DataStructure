package com.momoko.leetcode;

/**
 * Created by momoko on 2021/2/17.
 */
public class InsertionSortLinkList {
    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode tempHead = new ListNode(0,head);

        //当前从右边无序表中待排序的第一个节点
        ListNode cur = head.next;
        //左边有序表中的最后一个节点
        ListNode lastSorted = head;
        //遍历左边的有序表找到待插入的位置
        while (cur != null) {
            //当有序表的最后一个节点的值小于无序表的第一个节点时，直接后移
            if (lastSorted.val <= cur.val) {
                lastSorted = lastSorted.next;
            } else {
                //从头开始遍历左边的有序链表，找到待插入的位置
                ListNode prev = tempHead;
                while (prev.next.val <= cur.val) {
                    prev = prev.next;
                }
                //跳出循环时，就找到了待插入的位置，即直接插入到prev后面
                //同时链表后移
                lastSorted.next = cur.next;
                cur.next = prev.next;
                prev.next = cur;
            }
            cur = lastSorted.next;
        }
        return tempHead.next;
    }
}

 class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }