package com.momoko.linkedlist;

import java.util.List;

/**
 * Created by momoko on 2021/3/5.
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 */
public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//        if (l1 == null && l2 == null)
        //创建一个新的链表，先使用一个哑节点作为头节点
        ListNode dummy = new ListNode(0);
        ListNode l3 = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                l3.next = l1;
                l3 = l1;
                l1 = l1.next;
            } else {
                l3.next = l2;
                l3 = l2;
                l2 = l2.next;
            }
        }
        //连接剩下的没有比较的节点
        if (l1 != null) {
            l3.next = l1;
        } else {
            l3.next = l2;
        }
        return dummy.next;
    }
}