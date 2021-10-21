package com.learn.sub;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.ArrayList;
import java.util.List;

public class ValidateBinarySearchTree {
    List<Integer> integers;

    public boolean isValidBST(TreeNode root) {
        //create the integers
        this.integers = new ArrayList<>();
        this.preOrderList(root);
        for (int i = 0; i < integers.size()-1; i++) {
            if(this.integers.get(i) >= this.integers.get(i+1))
                return false;
        }
        return true;
    }

    private void preOrderList(TreeNode root){
        if(root == null)
            return;
        this.preOrderList(root.left);
        integers.add(root.val);
        this.preOrderList(root.right);
    }


    public static void main(String[] args) {
        ValidateBinarySearchTree validateBinarySearchTree = new ValidateBinarySearchTree();
        TreeNode treeNode = validateBinarySearchTree.createTree();
        Boolean aBoolean = validateBinarySearchTree.isValidBST(treeNode);
    }

    private TreeNode createTree() {
        TreeNode head = new TreeNode();
        head = new TreeNode(5, null, null);
        head.left = new TreeNode(1, null, null);
        head.right = new TreeNode(4, null, null);
        head.right.left = new TreeNode(3, null, null);
        head.right.right = new TreeNode(6, null, null);
        return head;
    }
}
