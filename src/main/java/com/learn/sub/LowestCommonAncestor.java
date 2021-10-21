package com.learn.sub;

import java.util.ArrayList;
import java.util.List;

public class LowestCommonAncestor {


    List<TreeNode> treeNodeList;

    public boolean isAncestor(TreeNode treeNode, TreeNode p){
        if(treeNode == null)
            return false;
        if(treeNode == p)
            return true;
        return isAncestor(treeNode.left, p) || isAncestor(treeNode.right, p);
    }


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.treeNodeList = new ArrayList<>();
        this.populateTreeNodeList(root); //populate the tree in inorder

        for (TreeNode treeNode:
             this.treeNodeList) {
            boolean containsP = this.isAncestor(treeNode, p);
            boolean containsQ = this.isAncestor(treeNode, q);
            if(containsP && containsQ)
                return treeNode;
        }
        return null;

    }

    private void populateTreeNodeList(TreeNode root) {
        if(root == null)
            return;
        this.populateTreeNodeList(root.left);
        this.populateTreeNodeList(root.right);
        this.treeNodeList.add(root);

    }

    public static void main(String[] args) {
        LowestCommonAncestor lowestCommonAncestor = new LowestCommonAncestor();
        TreeNode treeNode = lowestCommonAncestor.createTree();
        TreeNode aBoolean = lowestCommonAncestor.lowestCommonAncestor(treeNode, treeNode.left.right.left, treeNode.left.right.right);
        System.out.println(aBoolean.val);
    }

    private TreeNode createTree() {
        TreeNode head = new TreeNode();
        head = new TreeNode(6, null, null);
        head.left = new TreeNode(2, null, null);
        head.right = new TreeNode(8, null, null);
        head.left.left = new TreeNode(0, null, null);
        head.left.right = new TreeNode(4, null, null);
        head.right.right = new TreeNode(9, null, null);
        head.right.left = new TreeNode(7, null, null);
        head.left.right.left = new TreeNode(3, null, null);
        head.left.right.right = new TreeNode(5, null, null);
        return head;
    }
}
