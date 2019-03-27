package com.yishuailuo.mywebproject.algorithm.tree;

public class InvertBinaryTreeRecursiveSolution {
    
    
    public TreeNode invert(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode tempNode = root.left;
        root.left = invert(root.right);
        root.right = invert(tempNode);
        return root;
    }
    
    public static void main(String[] args) {
        
        TreeNode rootNode4 = new TreeNode(4);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode9 = new TreeNode(9);
        
        rootNode4.left = treeNode2;
        rootNode4.right = treeNode7;
        
        treeNode2.left = treeNode1;
        treeNode2.right = treeNode3;
        
        treeNode7.left = treeNode6;
        treeNode7.right = treeNode9;
        
        
        InvertBinaryTreeRecursiveSolution solution = new InvertBinaryTreeRecursiveSolution();
        TreeNode invertedBinaryTree = solution.invert(rootNode4);
        System.out.println(invertedBinaryTree);
        
    }
    
    
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        
        public TreeNode(int val) {
            this.val = val;
        }
    }
}
