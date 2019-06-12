package com.yishuailuo.mywebproject.algorithm.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TraverseBinaryTreeNonRecursiveSolution {

    public static void main(String[] args) {

        TreeNode treeNode4 = new TreeNode(4, null, null);
        TreeNode treeNode5 = new TreeNode(5, null, null);
        TreeNode treeNode2 = new TreeNode(2, treeNode4, treeNode5);

        TreeNode treeNode6 = new TreeNode(6, null, null);
        TreeNode treeNode7 = new TreeNode(7, null, null);
        TreeNode treeNode3 = new TreeNode(3, treeNode6, treeNode7);

        TreeNode root = new TreeNode(1, treeNode2, treeNode3);
        postOrderTraverse(root);

    }

    private static void levelTraverse(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.poll();
            if (treeNode != null) {
                System.out.print(treeNode.value);
                if (treeNode.left != null) {
                    queue.offer(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.offer(treeNode.right);
                }
            }
        }

    }

    private static void preOrderTraverse(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                System.out.print(root.value);
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            root = root.right;
        }
    }

    private static void inOrderTraverse(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            System.out.print(root.value);
            root = root.right;
        }

    }

    private static void postOrderTraverse(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curNode = root;
        TreeNode lastVisitNode = null;
        while (curNode != null) {
            stack.push(curNode);
            curNode = curNode.left;
        }

        while (!stack.isEmpty()) {
            curNode = stack.pop();
            if (curNode.right != null && curNode.right != lastVisitNode) {
                stack.push(curNode);
                curNode = curNode.right;
                while (curNode != null) {
                    stack.push(curNode);
                    curNode = curNode.left;
                }
            } else {
                System.out.print(curNode.value);
                lastVisitNode = curNode;
            }
        }
    }


    static class TreeNode {

        final int value;
        TreeNode left;
        TreeNode right;

        TreeNode(int value, TreeNode left, TreeNode right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

    }
}
