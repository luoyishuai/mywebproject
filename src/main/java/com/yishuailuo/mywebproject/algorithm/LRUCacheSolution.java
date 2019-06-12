package com.yishuailuo.mywebproject.algorithm;

import java.util.HashMap;

public class LRUCacheSolution {

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(3);
        lruCache.set("7", 7);
        lruCache.set("0", 0);
        lruCache.set("1", 1);
        lruCache.set("2", 2);
        lruCache.get("0");
        lruCache.set("3", 0);
        lruCache.get("0");
        lruCache.set("4", 0);
    }


    static class LRUCache {

        private HashMap<String, DLinkedNode> cache = new HashMap<>();
        private int count, capacity;
        private DLinkedNode head, tail;

        LRUCache(int capacity) {
            this.count = 0;
            this.capacity = capacity;
            head = new DLinkedNode();
            tail = new DLinkedNode();

            head.prev = null;
            head.next = tail;
            head.key = "head";

            tail.prev = head;
            tail.next = null;
            tail.key = "tail";
        }

        public void set(String key, int val) {

            DLinkedNode node = cache.get(key);

            if (node == null) {
                DLinkedNode newNode = new DLinkedNode();
                newNode.key = key;
                newNode.val = val;

                this.cache.put(key, newNode);
                this.addHead(newNode);

                count++;

                if (count > capacity) {
                    DLinkedNode tail = this.popTail();
                    this.cache.remove(tail.key);
                    --count;
                }

            } else {
                node.val = val;
                this.moveToHead(node);
            }
        }

        public int get(String key) {
            DLinkedNode node = this.cache.get(key);
            if (node == null) {
                return -1;
            }
            this.moveToHead(node);
            return node.val;
        }

        void addHead(DLinkedNode node) {
            head.next.prev = node;
            node.next = head.next;
            node.prev = head;
            head.next = node;
        }

        void removeNode(DLinkedNode node) {
            node.next.prev = node.prev;
            node.prev.next = node.next;
            node.next = null;
            node.prev = null;
        }

        void moveToHead(DLinkedNode node) {
            this.removeNode(node);
            this.addHead(node);
        }

        DLinkedNode popTail() {
            DLinkedNode res = tail.prev;
            this.removeNode(res);
            return res;
        }
    }

    static class DLinkedNode {
        String key;
        int val;
        DLinkedNode prev;
        DLinkedNode next;

        public DLinkedNode() {
        }

    }
}
