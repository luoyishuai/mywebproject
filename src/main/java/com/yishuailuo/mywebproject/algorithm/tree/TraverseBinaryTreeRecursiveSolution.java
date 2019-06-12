package com.yishuailuo.mywebproject.algorithm.tree;

public class TraverseBinaryTreeRecursiveSolution {

    public static void main(String[] args) {
        TraverseBinaryTreeRecursiveSolution solution = new TraverseBinaryTreeRecursiveSolution();

        TreeNode treeNode4 = new TreeNode(4, null, null);
        TreeNode treeNode5 = new TreeNode(5, null, null);
        TreeNode treeNode2 = new TreeNode(2, treeNode4, treeNode5);

        TreeNode treeNode6 = new TreeNode(6, null, null);
        TreeNode treeNode7 = new TreeNode(7, null, null);
        TreeNode treeNode3 = new TreeNode(3, treeNode6, treeNode7);

        TreeNode root = new TreeNode(1, treeNode2, treeNode3);

        System.out.println("**inOrder**");
        solution.inOrderTraverse(root);
        System.out.println();

        System.out.println("**preOrder**");
        solution.preOrderTraverse(root);
        System.out.println();

        System.out.println("**postOrder**");
        solution.postOrderTraverse(root);
        System.out.println();


    }


    private void inOrderTraverse(TreeNode root) {
        if (root != null) {
            inOrderTraverse(root.left);
            System.out.print(root.value + " ");
            inOrderTraverse(root.right);
        }
    }

    private void preOrderTraverse(TreeNode root) {
        if (root != null) {
            System.out.print(root.value + " ");
            preOrderTraverse(root.left);
            preOrderTraverse(root.right);
        }
    }

    private void postOrderTraverse(TreeNode root) {
        if (root != null) {
            postOrderTraverse(root.left);
            postOrderTraverse(root.right);
            System.out.print(root.value + " ");
        }
    }



    static class TreeNode {

        private final int value;
        private TreeNode left;
        private TreeNode right;

        TreeNode(int value, TreeNode left, TreeNode right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

    }
}
