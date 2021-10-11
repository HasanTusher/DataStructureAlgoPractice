package com.learn.sub;

public class SubTreeOfAnotherTree {

//    private boolean isSameTree(TreeNode root, TreeNode subRoot){
//        if(root==null && subRoot==null)
//            return true;
//        if(root == null && subRoot!=null)
//            return false;
//        if(subRoot == null)
//            return false;
//        if(root.val != subRoot.val)
//            return false;
//        else
//            return isSameTree(root.left, subRoot.left) && isSubtree(root.right, subRoot.right);
//    }
boolean areIdentical(TreeNode p, TreeNode q)
{

    /* base cases */
    if(p == null && q != null)
        return false;
    if(q == null && p != null)
        return false;
    if(p == null && q == null)
        return true;
    if(p.val == q.val)
        return areIdentical(p.left, q.left) && areIdentical(p.right, q.right);
    else
        return false;
}

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (subRoot == null)
            return true;

        if (root == null)
            return false;

        if (this.areIdentical(root, subRoot))
            return true;


        return isSubtree(root.left, subRoot)
                || isSubtree(root.right, subRoot);
    }
    public static void main(String[] args) {
        SubTreeOfAnotherTree subTreeOfAnotherTree = new SubTreeOfAnotherTree();
        TreeNode originalTree = subTreeOfAnotherTree.createTree();
        TreeNode subTree = subTreeOfAnotherTree.createTree2();
        boolean x = subTreeOfAnotherTree.isSubtree(originalTree, subTree);
        System.out.println(x);
    }

    private TreeNode createTree() {
        TreeNode head = new TreeNode();
        head = new TreeNode(3, null, null);
        head.left = new TreeNode(4, null, null);
        head.right = new TreeNode(5, null, null);
        head.left.left = new TreeNode(1, null, null);
        head.left.right = new TreeNode(2, null, null);
        return head;
    }


    private TreeNode createTree2() {
        TreeNode head = new TreeNode();
        head = new TreeNode(4, null, null);
        head.left = new TreeNode(1, null, null);
        head.right = new TreeNode(2, null, null);
//        head.right.left = new TreeNode(15, null, null);
//        head.right.right = new TreeNode(7, null, null);
        return head;
    }
}
