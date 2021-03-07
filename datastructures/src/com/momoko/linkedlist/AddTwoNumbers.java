package com.momoko.linkedlist;

/**
 * Created by momoko on 2021/3/5.
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 *
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 */
public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);
        ListNode l2 = new ListNode(9, l1);
        ListNode l3 = new ListNode(9, l2);
        ListNode l4 = new ListNode(9, l3);
        ListNode l5 = new ListNode(9, l4);
        ListNode l6 = new ListNode(9, l5);
        ListNode l7 = new ListNode(9, l6);
        ListNode l8 = new ListNode(9, l7);
        ListNode l9 = new ListNode(9, l8);
        ListNode l10 = new ListNode(1, l9);
        ListNode ll1 = new ListNode(9);
        ListNode listNode = addTwoNumbers(l10, ll1);


    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        //分别遍历两个链表，将两个链表代表的值求出来再相加（这里可以考虑递归怎么实现），最后将得到的数转化为链表（不可行，因为会溢出）
//        long total = calcNum(l1) + calcNum(l2);
//        ListNode dummy = new ListNode(0);
//        ListNode cur = dummy;
//        //将得到的数转为链表
//        while (total / 10 != 0) {
//            cur.next = new ListNode((int) (total % 10));
//            cur = cur.next;
//            total = total / 10;
//        }
//        //将最高位的数字加入
//        cur.next = new ListNode((int) total);
//        return dummy.next;
        //由于链表是逆序的，直接从两个链表的第一个开始相加，大于10该位置就置0，下一个位置再加1，到达最后节点时，如果还是有溢出了，则将溢出部分连接到链表尾
        ListNode head = null,tail = null;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            int sum = n1 + n2 + carry;
            if (head == null) {
                head = tail = new ListNode(sum % 10);
            } else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
            carry = sum / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            tail.next = new ListNode(carry);
        }
        return head;
    }
    public static long calcNum(ListNode head) {
        ListNode cur = head;
        long exp = 1;
        long num = 0;
        while (cur != null) {
            num += exp * cur.val;
            cur = cur.next;
            exp *= 10;
        }
        return num;
    }
}