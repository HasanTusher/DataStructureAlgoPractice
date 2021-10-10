package com.learn.sub;

public class InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {

    }



    public static void main(String[] args) {
        InvertBinaryTree invertBinaryTree = new InvertBinaryTree();
        TreeNode treeNode = invertBinaryTree.createTree();
        TreeNode newHead = invertBinaryTree.invertTree(treeNode);
        invertBinaryTree.traverse(newHead);
    }

    public void traverse(TreeNode newHead) {
        if(newHead!=null){
            System.out.println(newHead);
            this.traverse(newHead.left);
            this.traverse(newHead.right);
        }
    }

    public TreeNode createTree() {
        TreeNode head = new TreeNode();
        head = new TreeNode(3, null, null);
        head.left = new TreeNode(9, null, null);
        head.right = new TreeNode(20, null, null);
        head.right.left = new TreeNode(15, null, null);
        head.right.right = new TreeNode(7, null, null);
        return head;
    }
}
