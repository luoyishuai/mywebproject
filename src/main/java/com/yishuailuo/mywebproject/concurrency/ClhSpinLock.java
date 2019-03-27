package com.yishuailuo.mywebproject.concurrency;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 *  CLH 算法定义：
 *
 * the list, the application thread spin only on a local variable, it constantly polling the precursor state, if it is found that the pre release lock end spin.
 *
 * 实际上是通过自旋的方式实现加锁
 */
public class ClhSpinLock implements Lock {
    
    private final ThreadLocal<Node> prev;
    private final ThreadLocal<Node> node;
    private final AtomicReference<Node> tail = new AtomicReference<>(new Node());
    
    public ClhSpinLock() {
        this.node = new ThreadLocal<Node>() {
            @Override
            protected Node initialValue() {
                return new Node();
            }
        };
        
        this.prev = new ThreadLocal<Node>() {
            @Override
            protected Node initialValue() {
                return null;
            }
        };
    }
    
    /**
     * 1.初始状态 tail指向一个node(head)节点
     * +------+
     * | head | <---- tail
     * +------+
     *
     * 2.lock-thread加入等待队列: tail指向新的Node，同时Prev指向tail之前指向的节点
     * +----------+
     * | Thread-A |
     * | := Node  | <---- tail
     * | := Prev  | -----> +------+
     * +----------+        | head |
     *                     +------+
     *
     *             +----------+            +----------+
     *             | Thread-B |            | Thread-A |
     * tail ---->  | := Node  |     -->    | := Node  |
     *             | := Prev  | ----|      | := Prev  | ----->  +------+
     *             +----------+            +----------+         | head |
     *                                                          +------+
     * 3.寻找当前node的prev-node然后开始自旋
     *
     */
    @Override
    public void lock() {
        // 找到当前线程的 node，如果没有，则初始化一个新的 node
        final Node node = this.node.get();
        // 加锁
        node.locked = true;
        // 找到当前 node 的 prev-node
        Node prev = this.tail.getAndSet(node);
        this.prev.set(prev);
        // 自旋
        while (prev.locked) {
            // do nothing just spin on the local variable - pred.locked
        }
    }
    
    @Override
    public void unlock() {
        final Node node = this.node.get();
        // 无需获得锁
        node.locked = false;
        // 当前节点设置为 prev-node
        this.node.set(this.prev.get());
    }
    
    @Override
    public void lockInterruptibly() throws InterruptedException {
        // TODO Auto-generated method stub
        
    }
    
    @Override
    public boolean tryLock() {
        // TODO Auto-generated method stub
        return false;
    }
    
    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }
    
    
    @Override
    public Condition newCondition() {
        // TODO Auto-generated method stub
        return null;
    }
    
    private static class Node {
        /**
         * 供自旋的局部变量，为 true 表示需要获得锁
         */
        private volatile boolean locked;
    }
}