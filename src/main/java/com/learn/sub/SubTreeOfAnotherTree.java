package com.learn.sub;

public class SubTreeOfAnotherTree {

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return true;
    }
    public static void main(String[] args) {
        SubTreeOfAnotherTree subTreeOfAnotherTree = new SubTreeOfAnotherTree();
        TreeNode originalTree = subTreeOfAnotherTree.createTree();
        TreeNode subTree = subTreeOfAnotherTree.createTree2();
    }

    private TreeNode createTree() {
        TreeNode head = new TreeNode();
        head = new TreeNode(3, null, null);
        head.left = new TreeNode(4, null, null);
        head.right = new TreeNode(5, null, null);
        head.left.left = new TreeNode(1, null, null);
        head.left.right = new TreeNode(2, null, null);
        return head;
    }


    private TreeNode createTree2() {
        TreeNode head = new TreeNode();
        head = new TreeNode(4, null, null);
        head.left = new TreeNode(1, null, null);
        head.right = new TreeNode(2, null, null);
//        head.right.left = new TreeNode(15, null, null);
//        head.right.right = new TreeNode(7, null, null);
        return head;
    }
}
