package com.yishuailuo.mywebproject.algorithm;

public class AddTwoNumsSolution {

    public static void main(String[] args) {

        int[] arr1 = new int[]{2, 4};
        ListNode l1 = buildList(arr1);
        int[] arr2 = new int[]{4, 6, 4, 4};
        ListNode l2 = buildList(arr2);
        printList(l1);
        System.out.println();
        printList(l2);

        System.out.println();

        ListNode l3 = addTwoNum1(l1, l2);
        printList(l3);

    }

    private static ListNode addTwoNum1(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        int carry = 0;
        ListNode l3 = new ListNode(-1, null);
        ListNode l3Head = l3;
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                carry += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                carry += l2.val;
                l2 = l2.next;
            }
            l3.next = new ListNode(carry % 10, null);
            l3 = l3.next;
            carry = carry >= 10 ? 1 : 0;
        }
        if (carry == 1) {
            l3.next = new ListNode(1, null);
        }
        return l3Head.next;
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

    private static ListNode addTwoNum(ListNode l1, ListNode l2) {

        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        int carry = 0;
        // 需要添加 newHead 来指向新的链表头
        ListNode newHead = new ListNode(-1, null);
        ListNode l3 = newHead;

        while (l1 != null || l2 != null) {
            if (l1 != null) {
                carry += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                carry += l2.val;
                l2 = l2.next;
            }
            l3.next = new ListNode(carry % 10, null);
            carry = carry / 10;
            l3 = l3.next;
        }
        if (carry == 1) {
            l3.next = new ListNode(1, null);
        }
        return newHead.next;
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
