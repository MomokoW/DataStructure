package com.momoko.linkedlist;

/**
 * Created by momoko on 2021/3/5.
 * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 1->3->5->2->4->NULL
 */
public class OddEvenList {
    //方法一：分离链表后合并
    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode odds = head;
        ListNode even = odds.next;
        ListNode evenHead = even;
        while (even != null && even.next != null) {
            odds.next = even.next;
            odds = odds.next;
            even.next = odds.next;
            even = even.next;
        }
        odds.next = evenHead;
        return head;
    }
}