package com.yishuailuo.mywebproject.algorithm;

public class RightViewRecursiveSolution {

    private static int layer = 0;

    public static void main(String[] args) {
        TreeNode treeNode7 = new TreeNode(7, null, null);
        TreeNode treeNode6 = new TreeNode(6, treeNode7, null);
        TreeNode treeNode5 = new TreeNode(5, null, null);
        TreeNode treeNode3 = new TreeNode(3, null, null);
        TreeNode treeNode2 = new TreeNode(2, treeNode5, treeNode6);
        TreeNode root = new TreeNode(1, treeNode2, treeNode3);
        printRightView(root, 1);
    }

    private static void printRightView(TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        if (depth > layer) {
            System.out.print(root.val);
            layer++;
        }
        if (root.right != null) {
            printRightView(root.right, depth + 1);
        }
        if (root.left != null) {
            printRightView(root.left, depth + 1);
        }
    }


    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


}
