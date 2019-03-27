package com.yishuailuo.mywebproject.algorithm.tree;

import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class InvertBinaryTreeNonRecursiveSolution {
    
    
    public TreeNode invert(TreeNode root) {
        if (root == null) {
            return root;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while (!CollectionUtils.isEmpty(queue)) {
            TreeNode treeNode = queue.poll();
            if (treeNode != null) {
                TreeNode temp = treeNode.left;
                treeNode.left = treeNode.right;
                treeNode.right = temp;
                if (treeNode.left != null) {
                    queue.offer(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.offer(treeNode.right);
                }
            }
        }
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
        
        
        InvertBinaryTreeNonRecursiveSolution solution = new InvertBinaryTreeNonRecursiveSolution();
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
