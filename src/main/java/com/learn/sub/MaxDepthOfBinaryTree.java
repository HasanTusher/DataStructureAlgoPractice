package com.learn.sub;

import java.util.Arrays;
import java.util.List;

public class MaxDepthOfBinaryTree {

    public int maxDepth(TreeNode root) {
        return root == null ? 0 : Math.max(maxDepth(root.left), maxDepth(root.right))+1;
    }
    public static void main(String[] args) {
        MaxDepthOfBinaryTree maxDepthOfBinaryTree = new MaxDepthOfBinaryTree();
        List<Integer> integers = Arrays.asList(3,9,20,null,null,15,7) ;
        TreeNode treeNode = maxDepthOfBinaryTree.createTree(integers);
        System.out.println(maxDepthOfBinaryTree.maxDepth(treeNode));
    }

    private TreeNode createTree(List<Integer> integers) {
        TreeNode head = new TreeNode();
        head = new TreeNode(3, null, null);
        head.left = new TreeNode(9, null, null);
        head.right = new TreeNode(9, null, null);
        head.right.left = new TreeNode(15, null, null);
        head.right.right = new TreeNode(7, null, null);
        return head;
    }
}
