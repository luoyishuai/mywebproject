package com.yishuailuo.mywebproject.algorithm;

public class TwoListAreIntersetingSolution {


    public static void main(String[] args) {

        ListNode node10 = new ListNode(10, null);
        ListNode node9 = new ListNode(9, node10);
        ListNode node8 = new ListNode(8, node9);
        ListNode node7 = new ListNode(7, node8);
        ListNode node6 = new ListNode(6, node7);
        ListNode node5 = new ListNode(5, node6);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode head1 = new ListNode(1, node2);
        node10.setNext(node5);


        ListNode node23 = new ListNode(23, node5);
        ListNode node22 = new ListNode(22, node23);
        ListNode node21 = new ListNode(21, node22);
        ListNode head2 = new ListNode(20, node21);

        System.out.println(isIntersecting(head1, head2));
    }

    static boolean isIntersecting(ListNode head1, ListNode head2) {
        ListNode ringEntry1 = findRingEntry(head1);
        ListNode ringEntry2 = findRingEntry(head2);
        if (ringEntry1 != null && ringEntry2 == null) {
            // 一个有环一个无环，不相交
            return false;
        } else if (ringEntry1 == null && ringEntry2 == null) {
            // 两个都无环，先对齐，再一起遍历到链表尾，如果有相同节点则相交
            long diff = listLength(head1) - listLength(head2);
            for (int i = 0; i < Math.abs(diff); i++) {
                if (diff > 0) {
                    head1 = head1.next;
                } else if (diff < 0) {
                    head2 = head2.next;
                }
            }
            while (head1 != null) {
                if (head1 == head2) {
                    return true;
                }
                head1 = head1.next;
                head2 = head2.next;
            }
            return false;
        } else {
            // 两个都有环
            if (ringEntry1 == ringEntry2) {
                // 如果入口点一致，则相交
                return true;
            } else {
                // 如果入口点不一致，则让 l1 从入口点转一圈，如果有跟 l2 入口点相等的点，则相交，否则不相交
                while (ringEntry1 != null) {
                    ringEntry1 = ringEntry1.next;
                    if (ringEntry1 == ringEntry2) {
                        return true;
                    }
                }
                return false;
            }
        }
    }

    static long listLength(ListNode head) {
        ListNode newHead = head;
        long count = 0;
        while (newHead != null) {
            count++;
            newHead = newHead.next;
        }
        return count;
    }

    static ListNode findRingEntry(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                // 如果快慢指针相等，则有环，继续判断入环点，判断方式为快指针从头开始走，再次和慢指针相遇时，相遇的点则为入环点
                fast = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return fast;
            }
        }
        return null;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        void setNext(ListNode next) {
            this.next = next;
        }
    }
}
