package com.learn.sub;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;

public class KthSmallestElementInBst {

    private void inorderTraversal(TreeNode treeNode, List<Integer> integerList){
        if(treeNode == null)
            return;
        inorderTraversal(treeNode.left, integerList);
        integerList.add(treeNode.val);
        inorderTraversal(treeNode.right, integerList);

    }
    public int kthSmallest(TreeNode root, int k) {
        //create an array with inorder traversal
        List<Integer> integers = new ArrayList<>();
        this.inorderTraversal(root, integers);
        //return (k-1) th element
        return integers.get(k-1);
    }

    public static void main(String[] args) {
        KthSmallestElementInBst kthSmallestElementInBst = new KthSmallestElementInBst();
        TreeNode treeNode = kthSmallestElementInBst.createTree();
        int res= kthSmallestElementInBst.kthSmallest(treeNode, 1);
        System.out.println(res);
    }

    private TreeNode createTree() {
        TreeNode head = new TreeNode();
        head = new TreeNode(3, null, null);
        head.left = new TreeNode(1, null, null);
        head.right = new TreeNode(4, null, null);
//        head.left.left = new TreeNode(3, null, null);
        head.left.right = new TreeNode(2, null, null);
        return head;
    }
}
