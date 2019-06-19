package com.yishuailuo.mywebproject.algorithm.tree;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Stack;

public class TraverseBinaryTreeSolution1 {

    public static void main(String[] args) {

        TreeNode node7 = new TreeNode(7, null, null);
        TreeNode node6 = new TreeNode(6, null, null);
        TreeNode node5 = new TreeNode(5, null, null);
        TreeNode node4 = new TreeNode(4, null, null);
        TreeNode node3 = new TreeNode(3, node6, node7);
        TreeNode node2 = new TreeNode(2, node4, node5);
        TreeNode root = new TreeNode(1, node2, node3);

        prefixTraverseRecursive(root);
        System.out.println();
        prefixTraverse(root);
        System.out.println();
        infixTraverseRecursive(root);
        System.out.println();
        infixTraverse(root);
        System.out.println();
        postTraverseRecursive(root);
        System.out.println();
        postTraverse(root);
    }

    private static void prefixTraverseRecursive(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val);
        prefixTraverseRecursive(root.left);
        prefixTraverseRecursive(root.right);
    }

    private static void infixTraverseRecursive(TreeNode root) {
        if (root == null) {
            return;
        }
        infixTraverseRecursive(root.left);
        System.out.print(root.val);
        infixTraverseRecursive(root.right);
    }

    private static void postTraverseRecursive(TreeNode root) {
        if (root == null) {
            return;
        }
        postTraverseRecursive(root.left);
        postTraverseRecursive(root.right);
        System.out.print(root.val);
    }

    private static void prefixTraverse(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                System.out.print(root.val);
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            root = root.right;
        }
    }

    private static void infixTraverse(TreeNode root) {
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
            System.out.print(root.val);
            root = root.right;
        }
    }

    private static void postTraverse(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curNode = root;
        while(curNode != null) {
            stack.push(curNode);
            curNode = curNode.left;
        }
        TreeNode lastVisitedNode = curNode;
        while (!stack.isEmpty()) {
            curNode = stack.pop();
            if (curNode.right != null && curNode.right != lastVisitedNode) {
                stack.push(curNode);
                curNode = curNode.right;
                while (curNode != null) {
                    stack.push(curNode);
                    curNode = curNode.left;
                }
            } else {
                lastVisitedNode = curNode;
                System.out.print(curNode.val);
            }
        }
    }


    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
}
