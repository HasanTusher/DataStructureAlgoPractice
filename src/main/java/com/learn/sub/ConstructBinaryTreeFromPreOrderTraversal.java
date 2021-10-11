package com.learn.sub;

public class ConstructBinaryTreeFromPreOrderTraversal {

    public TreeNode actualBuildTree(int[] preoder, int position){
        if(position >= preoder.length)
            return null;
        TreeNode currentRoot = new TreeNode(preoder[position], null, null);
        int leftNode = position*2+1;
        int rightNode = position*2+2;
        currentRoot.left = this.actualBuildTree(preoder, leftNode);
        currentRoot.right = this.actualBuildTree(preoder, rightNode);
        return currentRoot;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode root = this.actualBuildTree(preorder, 0);
        this.traverse(root);
        return root;
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
        constructBinaryTreeFromPreOrderTraversal.buildTree(preorder, inorder);
    }
}
