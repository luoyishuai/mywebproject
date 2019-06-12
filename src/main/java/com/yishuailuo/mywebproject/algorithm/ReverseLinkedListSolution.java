package com.yishuailuo.mywebproject.algorithm;

public class ReverseLinkedListSolution {

    public static void main(String[] args) {

        int[] arr = new int[]{1, 2, 3, 4, 5};
        ListNode head = buildList(arr);
        ListNode reversedHead = reverse(head);
        printList(reversedHead);

    }

    private static ListNode buildList(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        ListNode nextNode = null;
        ListNode curNode = null;
        for (int i = arr.length - 1; i >= 0; i--) {
            curNode = new ListNode(arr[i], nextNode);
            nextNode = curNode;
        }
        return curNode;
    }

    private static void printList(ListNode head) {
        if (head == null) {
            System.out.println("empty list.");
        }
        do {
            System.out.print(head.val);
            head = head.next;
        } while (head != null);
    }

    private static ListNode reverse(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode prev = null;
        ListNode cur = head;
        ListNode next = head.next;
        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
