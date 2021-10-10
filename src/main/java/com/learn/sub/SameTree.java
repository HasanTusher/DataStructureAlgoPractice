package com.learn.sub;

import java.util.List;

public class SameTree {
    private int x;

    public boolean isSameTree(TreeNode p, TreeNode q) {

        if(p == null && q != null)
            return false;
        if(q == null && p != null)
            return false;
        if(p == null && q == null)
            return true;
        if(p.val == q.val)
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        else
            return false;


    }

    public static void main(String[] args) {
        SameTree sameTree = new SameTree();
        sameTree.x = 10;
        TreeNode leftTreeHead = sameTree.createTree();
        TreeNode rightTreeHead = sameTree.createTree2();
        System.out.println(sameTree.isSameTree(leftTreeHead, rightTreeHead));
    }

    private TreeNode createTree() {
        TreeNode head = new TreeNode();
        head = new TreeNode(3, null, null);
        head.left = new TreeNode(9, null, null);
        head.right = new TreeNode(20, null, null);
        head.right.left = new TreeNode(15, null, null);
        head.right.right = new TreeNode(7, null, null);
        return head;
    }


    private TreeNode createTree2() {
        TreeNode head = new TreeNode();
        head = new TreeNode(3, null, null);
        head.left = new TreeNode(9, null, null);
        head.right = new TreeNode(20, null, null);
        head.right.left = new TreeNode(15, null, null);
        head.right.right = new TreeNode(7, null, null);
        return head;
    }
}
