package com.momoko.tree.binarytree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by momoko on 2021/3/6.
 * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
 */
public class PreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        //前序遍历：先遍历根节点，再遍历左子树，最后遍历右子树
        //中序遍历：先遍历左子树，再遍历根节点，最后遍历右子树
        //后序遍历：先遍历左子树，再遍历右子树，最后遍历根节点
       List<Integer> res = new ArrayList<>();
       preOrder(root,res);
       return res;
    }
    public void preOrder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        preOrder(root.left,res);
        preOrder(root.right, res);
    }
}