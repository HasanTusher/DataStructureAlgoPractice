package com.learn.sub;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;

public class ConstructBinaryTreeFromPreOrderTraversal {

    public String addBinary(String a, String b) {
        BigInteger bigInteger = new BigInteger(a, 2);
        BigInteger bigInteger2 = new BigInteger(b, 2);
        BigInteger x = bigInteger.add(bigInteger2);
        String zz = x.toString(2);
        System.out.println(zz);
        return zz;
    }

    public TreeNode actualBuildTree(int[] preoder, int[] inorder, HashMap<Integer, Integer> hashMap, int  position){

        int root = preoder[position];
        int positionOfRoot = hashMap.get(root);

        int[] leftSubTree = new int[positionOfRoot];
        int[] rightSubTree = new int[preoder.length-positionOfRoot];
        return null;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> indexOfElementInOrder = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            indexOfElementInOrder.put(inorder[i], i);
        }
        return this.actualBuildTree(preorder, inorder, indexOfElementInOrder, 0);
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
//        ConstructBinaryTreeFromPreOrderTraversal constructBinaryTreeFromPreOrderTraversal = new ConstructBinaryTreeFromPreOrderTraversal();
        ConstructBinaryTreeFromPreOrderTraversal constructBinaryTreeFromPreOrderTraversal = new ConstructBinaryTreeFromPreOrderTraversal();
        constructBinaryTreeFromPreOrderTraversal.addBinary("1010", "1011");
    }
}
