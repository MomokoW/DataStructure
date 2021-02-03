package com.momoko.linkedlist;

/**
 * Created by momoko on 2021/2/2.
 */
public class Josepfu {
    public static void main(String[] args) {
        CircleSingleLinkedList linkedList = new CircleSingleLinkedList();
        linkedList.addBoy(5);
        linkedList.showList();
        linkedList.countKids(2,2,5);
    }

}

//创建一个环形的单向链表
class CircleSingleLinkedList {
    //创建一个first节点，当前没有编号
    private Kids first = null;
    
    //添加节点，构建成一个环形链表
    public void addBoy(int nums) {
        //数据校验
        if (nums < 1) {
            System.out.println("数据不正确");
            return;
        }

        Kids curKid = null;   //辅助构筑环形链表
        //使用for循环来创建环形链表
        for (int i = 1; i <= nums; i++) {
            //根据编号，创建节点
            Kids kid = new Kids(i);
            //考虑第一个小孩子节点
            if (i == 1) {
                first = kid;
                first.setNext(first);  //构成一个环
                curKid = first;
            } else {
                curKid.setNext(kid);
                kid.setNext(first);
                curKid = kid;
            }

        }
    }

    //遍历当前环形链表
    public void showList() {
        //判断链表是否为空
        if (first == null) {
            System.out.println("链表为空");
            return;
        }
        Kids cur = first;
        //使用while循环的好处：无需指定退出条件，就算只有一个节点也能打印出来
        while (true) {
            System.out.printf( "Kids no: %d\n", cur.getNo());
            if (cur.getNext() == first) {
                System.out.println("遍历完成");
                return;
            }
            cur = cur.getNext();

        }
    }

    //根据用户的输入，计算出圈的顺序

    /**
     * @param startNo 表示从第几个小孩开始数数
     * @param countNo 表示数几个
     * @param nums 表示最初有多少个小孩在圈中
     */
    public void countKids(int startNo, int countNo, int nums) {
        //校验
        if (first == null || startNo < 1 || startNo > nums) {
            System.out.println("参数输入有误");
            return;
        }
        //创建辅助节点,让它指向first的上一个节点
        Kids helper = first;
        while (true) {
            if (helper.getNext() == first) {
                break;
            }
            helper = helper.getNext();
        }
        //移动first和helper startNo - 1次
        for (int i = 0; i < startNo - 1; i++) {
            first = first.getNext();
            helper = helper.getNext();
        }
        //当小孩报数时，让first和helper指针同时移动countNo-1次，然后出圈，直到圈中只有一个节点
        while(helper != first) {
            for (int i = 0; i < countNo - 1; i++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            //这时first指向的节点，就是要出圈的小孩的节点
            System.out.printf("%d->",first.getNo());
            first = first.getNext();
            helper.setNext(first);
        }
        //到达最后一个报数节点
        System.out.printf("%d",first.getNo());
    }
}

//表示一个节点
class Kids {
    private int no; //标号
    private Kids next;

    public Kids(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Kids getNext() {
        return next;
    }

    public void setNext(Kids next) {
        this.next = next;
    }
}