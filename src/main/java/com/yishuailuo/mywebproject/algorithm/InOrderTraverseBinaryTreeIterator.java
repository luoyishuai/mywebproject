package com.yishuailuo.mywebproject.algorithm;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class InOrderTraverseBinaryTreeIterator {

    public static void main(String[] args) {
        TreeNode treeNode4 = new TreeNode(4, null, null);
        TreeNode treeNode5 = new TreeNode(5, null, null);
        TreeNode treeNode2 = new TreeNode(2, treeNode4, treeNode5);

        TreeNode treeNode6 = new TreeNode(6, null, null);
        TreeNode treeNode7 = new TreeNode(7, null, null);
        TreeNode treeNode3 = new TreeNode(3, treeNode6, treeNode7);

        TreeNode root = new TreeNode(1, treeNode2, treeNode3);

        // 遍历期间会输出节点值
        BinaryTreeIterator iterator = new postOrderIterator(root);

        System.out.println("\nStart Iterate");

        TreeNode node;
        while (iterator.hasNext()) {
            node = iterator.next();
            System.out.print(node.val);
        }
        System.out.println("\nFinish Iterate");
    }


    static class preOrderIterator extends BinaryTreeIterator {
        preOrderIterator(TreeNode root) {
            list = preOrderTraverse(root);
        }
    }

    static class inOrderIterator extends BinaryTreeIterator {
        inOrderIterator(TreeNode root) {
            list = inOrderTraverse(root);
        }
    }

    static class postOrderIterator extends BinaryTreeIterator {
        postOrderIterator(TreeNode root) {
            list = postOrderTraverse(root);
        }
    }

    static class levelOrderIterator extends BinaryTreeIterator {
        levelOrderIterator(TreeNode root) {
            list = levelOrderTraverse(root);
        }
    }

    static abstract class BinaryTreeIterator implements Iterator<TreeNode> {

        LinkedList<TreeNode> list;

        @Override
        public boolean hasNext() {
            return list != null && list.peek() != null;
        }

        @Override
        public TreeNode next() {
            return list.pop();
        }
    }

    private static LinkedList<TreeNode> preOrderTraverse(TreeNode root) {
        if (root == null) {
            return null;
        }
        LinkedList<TreeNode> list = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                System.out.print(root.val);
                list.add(root);
                root = root.left;
            }
            root = stack.pop();
            root = root.right;
        }
        return list;
    }

    private static LinkedList<TreeNode> inOrderTraverse(TreeNode root) {
        if (root == null) {
            return null;
        }
        LinkedList<TreeNode> list = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            System.out.print(root.val);
            list.add(root);
            root = root.right;
        }
        return list;
    }

    private static LinkedList<TreeNode> postOrderTraverse(TreeNode root) {
        if (root == null) {
            return null;
        }
        LinkedList<TreeNode> list = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curNode = root;
        TreeNode lastVisitedNode = null;
        while (curNode != null) {
            stack.push(curNode);
            curNode = curNode.left;
            lastVisitedNode = curNode;
        }
        while (!stack.isEmpty()) {
            curNode = stack.peek();
            if (curNode.right != null && curNode.right != lastVisitedNode) {
                curNode = curNode.right;
                while (curNode != null) {
                    stack.push(curNode);
                    curNode = curNode.left;
                    lastVisitedNode = curNode;
                }
            } else {
                curNode = stack.pop();
                System.out.print(curNode.val);
                list.add(curNode);
                lastVisitedNode = curNode;
            }
        }
        return list;
    }

    private static LinkedList<TreeNode> levelOrderTraverse(TreeNode root) {
        if (root == null) {
            return null;
        }
        LinkedList<TreeNode> list = new LinkedList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.push(root);
        while (!queue.isEmpty()) {
            root = queue.pop();
            System.out.print(root.val);
            list.add(root);
            if (root.left != null) {
                queue.offer(root.left);
            }
            if (root.right != null) {
                queue.offer(root.right);
            }
        }
        return list;
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
