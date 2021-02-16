package com.momoko.linkedlist;

import java.util.Stack;

/**
 * Created by momoko on 2021/1/29.
 */
public class SingleLinkedListDemo {
    public static void main(String[] args) {
        //创建节点
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");

        //创建单项链表
        SingleLikedList singleLikedList = new SingleLikedList();
        singleLikedList.addByOrder(hero1);
        singleLikedList.addByOrder(hero3);
        singleLikedList.addByOrder(hero2);
        singleLikedList.addByOrder(hero4);
        singleLikedList.list();



//        //修改节点
//        HeroNode heroL = new HeroNode(5, "小卢", "玉麒麟~~");
//        singleLikedList.update(heroL);
//        singleLikedList.list();
//        System.out.println();
//        //删除链表中的节点
//        singleLikedList.delete(4);
//
//        singleLikedList.list();

//        System.out.println(getLength(singleLikedList.getHead()));
//        HeroNode lastIndexNode = findLastIndexNode(singleLikedList.getHead(), 2);
//        System.out.println(lastIndexNode);
//
//        //反转链表
//        reverse(singleLikedList.getHead());
//        singleLikedList.list();

          //逆序打印链表
        reversePrint(singleLikedList.getHead());


    }
    /*
    思想
    1.编写一个方法，接收head节点，同时接收一个index
    2.index表示是倒数第index个节点
    3.先把链表从头到尾遍历，得到链表的总的长度getLength
    4.得到size后，从链表的第一个开始遍历（size-index+1）个
    5.如果找到了，则返回该节点，否则返回null
     */

    /**
     * 查找单链表的倒数第K个节点
     * @param k 给定的位置
     * @return 返回倒数第k个节点，如果存在，null如果不存在
     */
    public static HeroNode findLastIndexNode(HeroNode head, int k) {
        if (head.next == null) {
            return null;
        }
        int size = getLength(head);

        if (k <= 0 || k > size) {
            return null;
        }
        int pos = 0;
        HeroNode temp = head.next;
        //这是一种查找的方法
//        int searchIndex = size - k;
//        while (temp!= null) {
//            if (pos == searchIndex)
//                break;
//            pos++;
//            temp = temp.next;
//        }

        //这种查找方式更加直接
        for (int i = 0; i < size - k; i++) {
            temp = temp.next;
        }
        return temp;
    }


    /**
     * 获取单链表的节点的个数（如果时带头结点的链表，不统计头节点）
     * @param head 链表的头节点
     * @return 返回的就是有效节点的个数
     */
    public static int getLength(HeroNode head) {
        if (head.next == null) {
            return 0;
        }
        int length = 0;
        HeroNode temp = head.next;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        return length;
    }

    /**反转链表
     * 思路：额外开辟一个空间的办法
     * 先定义一个节点复制原有的头节点
     * 从头到尾遍历原来的链表，每遍历一个节点，就将其去除，并放在链表的最前端
     * 将原来的链表的head.next指向reverseHead.next
     * @param head 链表的头节点
     * @return 反转后的链表
     */
    public static void reverse(HeroNode head) {
        if (head.next == null || head.next.next == null) {
            return;
        }
        HeroNode reverseHead = new HeroNode(0,"","");
        HeroNode cur = head.next;
        HeroNode next = null;  //定义指向当前节点的下一个节点
        //遍历原来的链表
        while (cur != null) {
            next = cur.next;
            cur.next = reverseHead.next;
            reverseHead.next = cur;
            cur = next;
        }
        //遍历完之后将原来的头节点连接到反转到的链表上
        head.next = reverseHead.next;
    }

    //使用栈实现逆序打印
    public static void reversePrint(HeroNode head) {
        if (head.next == null) {
            return;  //空栈表，不打印
        }
        Stack<HeroNode> stack = new Stack<>();
        HeroNode cur = head.next;
        //将链表中的有效节点压入栈
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        //打印栈中的数据
        while (!stack.isEmpty()) {
            HeroNode node = stack.pop();
            System.out.println(node);
        }
    }
}

//定义SingleLikedList管理英雌
class SingleLikedList {
    //初始化一个头节点，头节点不要动
    private HeroNode head = new HeroNode(0, "", "");

    public HeroNode getHead() {
        return head;
    }

    //添加节点到单向链表

    /**
     * 思想，当不考虑编号顺序时
     * 找到当前链表的最后节点
     * 将最后这个节点的next指向新的节点
     */
    public void add(HeroNode node) {
        HeroNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
    }

    //按照给定的顺序插入链表
    public void addByOrder(HeroNode node) {
        //获取插入的位置
        HeroNode temp = head;
        while (temp.next != null) {
            if (temp.next.no > node.no) {
                break;
            } else if (temp.next.no == node.no) {
                System.out.println("编号重复，不能添加");
                return;
            }
            temp = temp.next;
        }
        //插入新节点
        node.next = temp.next;
        temp.next = node;

    }

    //修改节点的信息，根据no编号来修改
    public void update(HeroNode node) {
        //判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //获取头节点
        HeroNode temp = head;
        while (temp.next != null){
            //编号相等即为找到
            if (temp.no == node.no) {
                break;
            }
            temp = temp.next;
        }
        //找到最后一个还是没有找到
        if (temp.no != node.no) {
            System.out.printf("没有找到编号为%d的数据，无法修改\n",node.no);
            return;
        }
        temp.name = node.name;
        temp.nickname = node.nickname;

    }

    /**
     * 从单链表中删除节点
     * 找到待删除节点的上一个节点
     * 让前一个节点的next域指向待删除节点的next域
     */
    public void delete(int no) {
        //判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空，无法删除");
            return;
        }
        HeroNode temp = head;
        while (temp.next != null) {
            //找到待删除节点的上一个节点，或者最后一个节点的前一个节点
            if (temp.next.no == no || temp.next.next == null) {
                break;
            }
            temp = temp.next;
        }
        //判断最后一个节点是否为要删除的节点
        if (temp.next.no != no) {
            System.out.printf("没有找到编号为%d的数据，删除错误\n",no);
            return;
        }
        temp.next = temp.next.next;

    }

    //显示链表
    public void list() {
        //判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = head.next;
        while (temp != null) {
            //输出节点信息
            System.out.println(temp);
            temp = temp.next;
        }
    }

}


//定义HeroNode
class HeroNode {
    public int no;
    public String name;
    public String nickname;
    public HeroNode next;   //指向下一个节点

    public HeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname +
                '}';
    }

}