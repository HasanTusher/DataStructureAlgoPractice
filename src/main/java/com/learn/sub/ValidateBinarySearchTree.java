package com.learn.sub;

public class ValidateBinarySearchTree {

    public boolean isValidBST(TreeNode root) {
        if(root == null)
            return true;
        if(root.right == null && root.left == null)
            return true;

        boolean isLeftSubTreeValid = isValidBST(root.left);
        boolean isRightSubTreeValid = isValidBST(root.right);
        if(isLeftSubTreeValid && isRightSubTreeValid && this.isRootValid(root))
        {
            return true;
        }else
            return false;
    }

    private boolean isRootValid(TreeNode root) {
        if(root.left !=null && root.left.val >= root.val)
            return false;
        if(root.right !=null && root.right.val <= root.val)
            return false;
        return true;
    }

    public static void main(String[] args) {
        ValidateBinarySearchTree validateBinarySearchTree = new ValidateBinarySearchTree();
        TreeNode treeNode = validateBinarySearchTree.createTree();
        validateBinarySearchTree.isValidBST(treeNode);
    }

    private TreeNode createTree() {
        TreeNode head = new TreeNode();
        head = new TreeNode(5, null, null);
        head.left = new TreeNode(4, null, null);
        head.right = new TreeNode(6, null, null);
        head.right.left = new TreeNode(3, null, null);
        head.right.right = new TreeNode(7, null, null);
        return head;
    }
}
