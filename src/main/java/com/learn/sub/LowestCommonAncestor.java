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
        this.treeNodeList.add(root);
        this.populateTreeNodeList(root.right);
    }

    public static void main(String[] args) {
        LowestCommonAncestor lowestCommonAncestor = new LowestCommonAncestor();
        TreeNode treeNode = lowestCommonAncestor.createTree();
        TreeNode aBoolean = lowestCommonAncestor.lowestCommonAncestor(treeNode, treeNode.left, treeNode.right);
        System.out.println(aBoolean.val);
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
