package com.yishuailuo.mywebproject.concurrency;

import org.apache.http.annotation.GuardedBy;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionBoundBuffer<T> {
    
    private final Lock lock = new ReentrantLock();
    private final Condition notFull = lock.newCondition();
    private final Condition notEmpty = lock.newCondition();
    @GuardedBy("lock") private T[] items = (T[]) new Object[10];
    @GuardedBy("lock") private int head, tail, count = 0;
    
    public void put(T t) {
        lock.lock();
        try {
            while (count == items.length) {
                notFull.await();
            }
            items[tail] =  t;
            if (++tail == items.length) {
                tail = 0;
            }
            ++count;
            System.out.println("put success, count: " + count);
            notEmpty.signal();
        } catch (Exception e) {
            lock.unlock();
        }
    }
    
    public T take() throws InterruptedException {
        lock.lock();
        try {
            while (count == 0) {
                notEmpty.await();
            }
            T x = items[head];
            if (++head == items.length) {
                head = 0;
            }
            --count;
            System.out.println("take success, count: " + count + ", take x=" + x);
            notFull.signal();
            return x;
        } finally {
            lock.unlock();
        }
    }
    
}
