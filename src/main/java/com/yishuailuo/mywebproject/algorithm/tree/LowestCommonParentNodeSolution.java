package com.yishuailuo.mywebproject.algorithm.tree;

public class LowestCommonParentNodeSolution {

    public static void main(String[] args) {

        TreeNode node4 = new TreeNode(4, null, null);
        TreeNode node5 = new TreeNode(5, null, null);
        TreeNode node2 = new TreeNode(2, node4, node5);

        TreeNode node6 = new TreeNode(6, null, null);
        TreeNode node7 = new TreeNode(7, null, null);
        TreeNode node3 = new TreeNode(3, node6, node7);

        TreeNode root = new TreeNode(1, node2, node3);
        TreeNode result = lowestCommonAncestor(root, node2, node3);
        System.out.println(result.val);

    }

    static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode l = lowestCommonAncestor(root.left, p, q);
        TreeNode r = lowestCommonAncestor(root.right, p, q);
        return l != null && r != null ? root : l == null ? r : l;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
