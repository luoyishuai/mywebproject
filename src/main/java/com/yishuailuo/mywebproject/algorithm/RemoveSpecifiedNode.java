package com.yishuailuo.mywebproject.algorithm;

public class RemoveSpecifiedNode {

    public static void main(String[] args) {

        DoubleLinkedNode tail = new DoubleLinkedNode(-1);
        DoubleLinkedNode head = new DoubleLinkedNode(-1);
        DoubleLinkedNode node1 = new DoubleLinkedNode(1);
        DoubleLinkedNode node2 = new DoubleLinkedNode(2);
        DoubleLinkedNode node3 = new DoubleLinkedNode(3);
        DoubleLinkedNode node4 = new DoubleLinkedNode(4);
        DoubleLinkedNode node5 = new DoubleLinkedNode(5);

        head.next = node1;
        node1.next = node2;
        node1.prev = head;
        node2.next = node3;
        node2.prev = node1;
        node3.next = node4;
        node3.prev = node2;
        node4.next = node5;
        node4.prev = node3;
        node5.next = tail;
        node5.prev = node4;

        printDoubleLinkedList(head);
        System.out.println();
        DoubleLinkedNode result = removeSpecifiedNode(head, node1);
        printDoubleLinkedList(result);
    }

    private static DoubleLinkedNode removeSpecifiedNode(DoubleLinkedNode head, DoubleLinkedNode specifiedNode) {
        if (head == null || specifiedNode == null) {
            return head;
        }
        DoubleLinkedNode nextNode = specifiedNode.next;
        specifiedNode.val = nextNode.val;
        if (nextNode.next != null) {
            // 下一个节点的 next 不为 null，说明当前节点不是 tail，那么删除的节点不是倒数第一个
            nextNode.next.prev = specifiedNode;
            specifiedNode.next = nextNode.next;
            nextNode = null;
        } else {
            // 下一个节点的 next 为 null，说明当前节点是 tail，那么删除的节点不是倒数第一个
            specifiedNode.next = null;
        }
        return head;
    }

    private static void printDoubleLinkedList(DoubleLinkedNode head) {
        while (head != null) {
            System.out.print(head.val + ",");
            head = head.next;
        }
    }

    private static DoubleLinkedNode buildDoubleLinked(int[] arr) {
        return null;
    }

    static class DoubleLinkedNode {
        int val;
        DoubleLinkedNode prev;
        DoubleLinkedNode next;

        DoubleLinkedNode(int val) {
            this.val = val;
        }
    }

}
