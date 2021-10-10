package com.learn.sub;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class BinaryTreeLevelOrderTraversal {


    private List<List<Integer>> postOrderTraversal(TreeNode root, TreeNode actualRoot) {
        if(root == null)
            return Collections.emptyList();
        List<List<Integer>> left = this.postOrderTraversal(root.left, root);
        List<List<Integer>> right = this.postOrderTraversal(root.right, root);

        List<List<Integer>> res = new ArrayList<>();
        if(root == actualRoot)
            res.add(Arrays.asList(root.val));

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

    public List<List<Integer>> levelOrder(TreeNode root) {
        return this.postOrderTraversal(root, root);
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
