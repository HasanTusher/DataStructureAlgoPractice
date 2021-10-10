package com.learn.sub;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class BinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null)
            return Collections.emptyList();
        List<List<Integer>> left = this.levelOrder(root.left);
        List<List<Integer>> right = this.levelOrder(root.right);

        List<List<Integer>> res = new ArrayList<>();
        if(root.left !=null || root.right != null)
        {
            List<Integer> tempRes = new ArrayList<>();
            if(root.left!=null)
                tempRes.add(root.left.val);
            if(root.right!=null)
                tempRes.add(root.right.val);
            res.add(tempRes);
        }

        if(!left.isEmpty())
            res.addAll(left);
        if(!right.isEmpty())
            res.addAll(right);

        return res;
    }


    public static void main(String[] args) {
        BinaryTreeLevelOrderTraversal binaryTreeLevelOrderTraversal = new BinaryTreeLevelOrderTraversal();
        TreeNode treeNode = binaryTreeLevelOrderTraversal.createTree();
        List<List<Integer>> lists = binaryTreeLevelOrderTraversal.levelOrder(treeNode);
        lists.forEach(r-> r.forEach(System.out::println));
        System.out.println("ayya");
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
