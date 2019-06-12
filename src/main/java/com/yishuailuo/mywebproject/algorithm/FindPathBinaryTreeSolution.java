package com.yishuailuo.mywebproject.algorithm;

import java.util.Stack;

public class FindPathBinaryTreeSolution {

    public static void main(String[] args) {
        TreeNode treeNode4 = new TreeNode(4, null, null);
        TreeNode treeNode5 = new TreeNode(7, null, null);
        TreeNode treeNode2 = new TreeNode(5, treeNode4, treeNode5);

        TreeNode treeNode3 = new TreeNode(12, null, null);

        TreeNode root = new TreeNode(10, treeNode2, treeNode3);
        findPath(root, 22, new Stack<>());

    }

    static void findPath(TreeNode root, int k, Stack<Integer> path) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            if (root.val == k) {
                System.out.print("[");
                for (int i : path) {
                    System.out.print(i + ",");
                }
                System.out.print(root.val);
                System.out.print("]");
            }
        } else {
            path.add(root.val);
            findPath(root.left, k - root.val, path);
            findPath(root.right, k - root.val, path);
            path.pop();
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
