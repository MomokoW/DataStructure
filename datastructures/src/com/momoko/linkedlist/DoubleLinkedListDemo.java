package com.momoko.linkedlist;

/**
 * Created by momoko on 2021/2/1.
 */
public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        System.out.println("双向链表的测试");
        //创建节点
        HeroNode2 hero1 = new HeroNode2(1, "宋江", "及时雨");
        HeroNode2 hero2 = new HeroNode2(2, "卢俊义", "玉麒麟");
        HeroNode2 hero3 = new HeroNode2(3, "吴用", "智多星");
        HeroNode2 hero4 = new HeroNode2(4, "林冲", "豹子头");

        //创建双向链表
        DoubleLinkedList dlinkedList = new DoubleLinkedList();
        dlinkedList.addByOrder(hero1);
        dlinkedList.addByOrder(hero3);
        dlinkedList.addByOrder(hero2);
        dlinkedList.addByOrder(hero4);

        //打印双向链表
        dlinkedList.list();

        //修改
        HeroNode2 heroL = new HeroNode2(2, "小卢", "玉麒麟~~");
        dlinkedList.update(heroL);
        dlinkedList.list();

        System.out.println("***********删除后*********");
        //删除
        dlinkedList.delete(3);
        dlinkedList.list();

    }
}

//创建双向链表的类
class DoubleLinkedList {

    //先初始化一个头节点，头节点不要动
    private HeroNode2 head = new HeroNode2(0,"","");

    //返回头节点
    public HeroNode2 getHead() {
        return head;
    }

    //遍历双向链表的方法
    public void list() {
        //判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        HeroNode2 temp = head.next;
        while (temp != null) {
            //输出节点信息
            System.out.println(temp);
            temp = temp.next;
        }
    }

    //添加数据到双向链表尾部
    public void add(HeroNode2 node) {
        HeroNode2 temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
        node.pre = temp;
    }

    //按照给定的顺序插入链表
    public void addByOrder(HeroNode2 node) {
        //找到指定位置的节点的前一个节点
        HeroNode2 temp = head;
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
        node.pre = temp;
        //如果是最后一个节点，则不需要连接下一个节点的前一个节点
        if (temp.next != null) {
            temp.next.pre = node;
        }
        temp.next = node;

    }



    //修改节点的信息，根据no编号来修改
    public void update(HeroNode2 node) {
        //判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //获取头节点
        HeroNode2 temp = head;
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
     * 从双向链表中删除节点
     * 找到待删除节点
     * 让前一个节点的next域指向待删除节点的next域
     * 让下一个节点的pre域指向待删除结点的pre域
     */
    public void delete(int no) {
        //判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空，无法删除");
            return;
        }
        HeroNode2 temp = head.next;
        while (temp != null) {
            //找到待删除节点
            if (temp.no == no) {
                break;
            }
            temp = temp.next;
        }
        //判断是否找到了待删除节点
        if (temp == null) {
            System.out.printf("没有找到编号为%d的数据，删除错误\n",no);
            return;
        }
        //连接前后两个节点
        temp.pre.next = temp.next;
        //如果删除的是最后一个节点，则不需要连接前一个节点
        if (temp.next != null) {
            temp.next.pre  = temp.pre;

        }

    }

}

//定义HeroNode2，每个HeroNode2就是一个节点
class HeroNode2 {
    public int no;
    public String name;
    public String nickname;
    public HeroNode2 next;   //指向下一个节点
    public HeroNode2 pre;    //指向前一个节点

    public HeroNode2(int no, String name, String nickname) {
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