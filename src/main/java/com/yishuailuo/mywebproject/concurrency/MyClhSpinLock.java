package com.yishuailuo.mywebproject.concurrency;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class MyClhSpinLock implements Lock {
    
    private ThreadLocal<Node> prev;
    private ThreadLocal<Node> node;
    private AtomicReference<Node> tail = new AtomicReference<>(new Node());
    
    public MyClhSpinLock() {
        
        prev = new ThreadLocal<Node>() {
            @Override
            protected Node initialValue() {
                return null;
            }
        };
        
        node = new ThreadLocal<Node>() {
            @Override
            protected Node initialValue() {
                return new Node();
            }
        };
    }
    
    @Override
    public void lock() {
        Node node = this.node.get();
        node.locked = true;
        Node prev = this.tail.getAndSet(node);
        this.prev.set(prev);
    }
    
    @Override
    public void unlock() {
        Node node = this.node.get();
        node.locked = false;
        this.node.set(this.prev.get());
    }
    
    @Override
    public void lockInterruptibly() throws InterruptedException {
    
    }
    
    @Override
    public boolean tryLock() {
        return false;
    }
    
    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }
    
    @Override
    public Condition newCondition() {
        return null;
    }
    
    private class Node {
        public boolean locked;
    }
}
