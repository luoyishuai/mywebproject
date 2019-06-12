package com.yishuailuo.mywebproject.algorithm.tree;

import java.util.Stack;

public class InvertBTSolutionNew {

    public static void main(String[] args) {
        TreeNode treeNode4 = new TreeNode(4, null, null);
        TreeNode treeNode5 = new TreeNode(5, null, null);

        TreeNode treeNode6 = new TreeNode(6, null, null);
        TreeNode treeNode7 = new TreeNode(7, null, null);

        TreeNode treeNode2 = new TreeNode(2, treeNode4, treeNode5);
        TreeNode treeNode3 = new TreeNode(3, treeNode6, treeNode7);

        TreeNode root = new TreeNode(1, treeNode2, treeNode3);
        preOrderTraverse(root);
        System.out.println();
        TreeNode result = invertNonRecursive(root);
        System.out.println();
        preOrderTraverse(result);
        System.out.println();
    }

    private static void preOrderTraverse(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val);
        preOrderTraverse(root.left);
        preOrderTraverse(root.right);
    }

    private static void inOrderTraverse(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrderTraverse(root.left);
        System.out.print(root.val);
        inOrderTraverse(root.right);
    }

    private static void postOrderTraverse(TreeNode root) {
        if (root == null) {
            return;
        }
        postOrderTraverse(root.left);
        postOrderTraverse(root.right);
        System.out.print(root.val);
    }

    private static TreeNode invert(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return root;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        if (root.left != null) {
            invert(root.left);
        }
        if (root.right != null) {
            invert(root.right);
        }
        return root;
    }

    private static TreeNode invertNonRecursive(TreeNode root) {
        if (root == null) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode result = root;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                TreeNode temp = root.left;
                root.left = root.right;
                root.right = temp;
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            root = root.right;
        }
        return result;
    }

    private static TreeNode preOrderTraverseNonRecursive(TreeNode root) {
        if (root == null) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                System.out.print(root.val);
                root = root.left;
            }
            root = stack.pop();
            root = root.right;
        }
        return root;
    }

    private static TreeNode inOrderTraverseNonRecursive(TreeNode root) {
        if (root == null) {
            return null;
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
        return root;
    }

    private static TreeNode postOrderTraverseNonRecursive(TreeNode root) {
        if (root == null) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
        TreeNode lastVisitedNode = root;
        while (!stack.isEmpty()) {
            root = stack.pop();
            if (root.right != null && root.right != lastVisitedNode) {
                stack.push(root);
                root = root.right;
                while (root != null) {
                    stack.push(root);
                    root = root.left;
                }
            } else {
                System.out.print(root.val);
                lastVisitedNode = root;
            }
        }
        return root;
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
