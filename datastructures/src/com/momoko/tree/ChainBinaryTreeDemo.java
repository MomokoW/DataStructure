package com.momoko.tree;

/**
 * Created by momoko on 2021/3/6.
 */
public class ChainBinaryTreeDemo {

}

class HeroNode {
    private int no;
    private String name;

    private HeroNode left;  //默认为null
    private HeroNode right; //默认为null

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HeroNode[" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", left=" + left +
                ", right=" + right +
                ']';
    }

    //前序遍历
    public void preOrder() {
        System.out.println(this);   //先输出父节点
        //递归向左子树前序遍历
        if (this.left != null) {
            this.left.preOrder();
        }
        //递归向右子树谦虚遍历
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    //中序遍历
    public void infixOrder() {
        //递归向左子树中序遍历
        if (this.left != null) {
            this.left.infixOrder();
        }
        //输出父节点
        System.out.println(this);
        //递归向右子树中序遍历
        if (this.right != null) {
            this.right.infixOrder();
        }
    }

    //后序遍历
    public void suffixOrder() {
        //递归向左子树后序遍历
        if (this.left != null) {
            this.left.suffixOrder();
        }
        //递归向右子树后序遍历
        if (this.right != null) {
            this.right.suffixOrder();
        }
        //输出父节点
        System.out.println(this);
    }
}