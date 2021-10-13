package com.learn.sub;

import java.util.*;
import java.util.stream.Collectors;

public class BinaryTreeLevelOrderTraversal {


    private List<List<Integer>> postOrderTraversal(TreeNode root) {
        if(root == null)
            return Collections.emptyList();
        List<List<Integer>> lists = new ArrayList<>();
        Queue<TreeNode> leftQueue = new LinkedList<>();
        Queue<TreeNode> rightQueue = new LinkedList<>();
        boolean pollFromFirst = true; //if true poll from first else from last
        List<Integer> res = new ArrayList<>();
        leftQueue.add(root);
        while (!leftQueue.isEmpty() || !rightQueue.isEmpty()){
            if(pollFromFirst == true && leftQueue.isEmpty() ){
                //add the res to the lists
                lists.add(res);
                res = new ArrayList<>();
                pollFromFirst = false;
                continue;

            }

            if(pollFromFirst == false && rightQueue.isEmpty()){
                lists.add(res);
                res = new ArrayList<>();
                pollFromFirst = true;
                continue;
            }

            if(pollFromFirst == true)
            {
                TreeNode treeNode = leftQueue.poll();
                res.add(treeNode.val);
                if(treeNode.left!=null)
                    rightQueue.add(treeNode.left);
                if(treeNode.right != null)
                    rightQueue.add(treeNode.right);
            }else{
                TreeNode treeNode = rightQueue.poll();
                res.add(treeNode.val);
                if(treeNode.left!=null)
                    leftQueue.add(treeNode.left);
                if(treeNode.right != null)
                    leftQueue.add(treeNode.right);
            }
        }
        lists.add(res);

        return lists;
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        return this.postOrderTraversal(root);
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
        head = new TreeNode(1, null, null);
        head.left = new TreeNode(2, null, null);
        head.right = new TreeNode(3, null, null);
        head.left.left = new TreeNode(4, null, null);
        head.left.right = new TreeNode(5, null, null);;
        head.right.left = new TreeNode(6, null, null);;;
        head.right.right = new TreeNode(7, null, null);
        return head;
    }

}
