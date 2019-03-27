package com.yishuailuo.mywebproject.concurrency;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.Lock;

public class MyClhSpinLockMainTest {
    
    private static int count = 0;
    
    public static void main(String[] args) {
        final MyClhSpinLock myClhSpinLock = new MyClhSpinLock();
        final CyclicBarrier cyclicBarrier = new CyclicBarrier(10, new Runnable() {
            @Override
            public void run() {
                System.out.println("count:" + count);
            }
        });
        
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    count(myClhSpinLock);
                    try {
                        cyclicBarrier.await();
                    } catch (InterruptedException | BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }
    
    private static void count(Lock lock) {
        lock.lock();
        try {
            count++;
            System.out.println(count);
        } finally {
            lock.unlock();
        }
    }
}
