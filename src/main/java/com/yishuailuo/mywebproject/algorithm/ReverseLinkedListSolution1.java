package com.yishuailuo.mywebproject.algorithm;

public class ReverseLinkedListSolution1 {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7};
        ListNode head = buildLinkedList(arr);
        printLinkedList(head);
        System.out.println();
        ListNode result = reverseLinkedListByNStep(head, 3);
        printLinkedList(result);
        System.out.println();
    }

    static ListNode buildLinkedList(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        ListNode cur = null;
        ListNode next = null;
        for (int i = arr.length - 1; i >= 0; i--) {
            cur = new ListNode(arr[i], next);
            next = cur;
        }
        return cur;
    }

    static void printLinkedList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            head = head.next;
        }
    }

    static ListNode reverseLinkedListByNStep(ListNode head, int n) {
        if (head == null || n <= 0) {
            return null;
        }
        ListNode prev = null;
        ListNode cur = head;
        ListNode next;
        ListNode stepNode = cur;
        while (cur != null) {
            for (int i = 0; i < n && stepNode != null; i++) {
                stepNode = stepNode.next;
            }
            while (cur != stepNode) {
                next = cur.next;
                cur.next = prev;
                prev = cur;
                cur = next;
            }
        }
        return prev;
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
