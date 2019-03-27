package com.yishuailuo.mywebproject.concurrency;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.Lock;

public class ClhSpinLockMainTest {
    
    private static int count = 0;
    
    private static void testLock(Lock lock) {
        try {
            // 加上自旋锁
            lock.lock();
            ++count;
        } finally {
            lock.unlock();
        }
    }
    
    public static void main(String[] args) throws InterruptedException, BrokenBarrierException {
        
        final ClhSpinLock clh = new ClhSpinLock();
        // 栅栏
        final CyclicBarrier cb = new CyclicBarrier(10, new Runnable() {
            @Override
            public void run() {
                System.out.println(count);
            }
        });
        
        // 开10个线程进行 ++count
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    testLock(clh);
                    try {
                        cb.await();
                    } catch (InterruptedException | BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }
    
    
}
