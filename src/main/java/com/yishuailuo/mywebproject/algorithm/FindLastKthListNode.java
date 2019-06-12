package com.yishuailuo.mywebproject.algorithm;

public class FindLastKthListNode {

    public static void main(String[] args) {
        int[] arr = new int[]{5, 4, 3, 2, 1};
        ListNode headNode = buildList(arr);

        ListNode lastKthListNode = findLastKthListNode(headNode, 2);
        if (lastKthListNode != null) {
            System.out.println(lastKthListNode.val);
        } else {
            System.out.println("Could not find listNode.");
        }
    }

    private static ListNode buildList(int[] arr) {
        if (arr == null) {
            return null;
        }
        if (arr.length == 1) {
            return new ListNode(arr[arr.length - 1], null);
        }
        ListNode curNode = null;
        ListNode nextNode = new ListNode(arr[arr.length - 1], null);
        for (int i = arr.length - 2; i >= 0; i--) {
            curNode = new ListNode(arr[i], nextNode);
            nextNode = curNode;
        }
        return curNode;
    }

    private static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            head = head.next;
        }
    }

    private static ListNode findLastKthListNode(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode p1 = head;
        ListNode p2 = head;

        for (int i = 0; i < k; i++) {
            if (p1 == null) {
                return null;
            } else {
                p1 = p1.next;
            }
        }

        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;

    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
