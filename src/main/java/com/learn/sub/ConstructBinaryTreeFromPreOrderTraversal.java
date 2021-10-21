package com.learn.sub;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;

public class ConstructBinaryTreeFromPreOrderTraversal {
    int primaryIndex;
    public TreeNode actualBuildTree(int[] preoder, HashMap<Integer, Integer> hashMap, int start, int end){
        if(start > end)
            return null;

        int rootVal = preoder[this.primaryIndex++];
        TreeNode node = new TreeNode(rootVal);

        node.left = this.actualBuildTree(preoder, hashMap, start, hashMap.get(rootVal)-1);
        node.right = this.actualBuildTree(preoder, hashMap, hashMap.get(rootVal)+1, end);
        return node;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> indexOfElementInOrder = new HashMap<>();
        this.primaryIndex = 0;

        for (int i = 0; i < inorder.length; i++) {
            indexOfElementInOrder.put(inorder[i], i);
        }
        return this.actualBuildTree(preorder, indexOfElementInOrder,  0, preorder.length-1);
    }

    public void traverse(TreeNode newHead) {
        if(newHead!=null){
            System.out.println(newHead.val);
            this.traverse(newHead.left);
            this.traverse(newHead.right);
        }else
            System.out.println("null");
    }

    public static void main(String[] args) {

        int[] preorder = {3,9,20,15,7}; int[] inorder = {9,3,15,20,7};
        ConstructBinaryTreeFromPreOrderTraversal constructBinaryTreeFromPreOrderTraversal = new ConstructBinaryTreeFromPreOrderTraversal();
        TreeNode treeNode = constructBinaryTreeFromPreOrderTraversal.buildTree(preorder, inorder);
        constructBinaryTreeFromPreOrderTraversal.traverse(treeNode);
    }
}
