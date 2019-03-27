package com.yishuailuo.mywebproject.concurrency.oddevenprint;

import java.util.concurrent.Semaphore;

public class MultiThreadOrderPrinterSemaphore {
    
    private static volatile int VALUE = 0;
    
    private int threadCount;
    private int maxNum;
    
    public MultiThreadOrderPrinterSemaphore(int threadCount, int maxNum) {
        this.threadCount = threadCount;
        this.maxNum = maxNum;
    }
    
    public void print() throws InterruptedException {
        
        Semaphore[] semaphores = new Semaphore[threadCount];
        for (int i = 0; i < threadCount; i++) {
            semaphores[i] = new Semaphore(1);
            if (i != threadCount - 1) {
                semaphores[i].acquire();
            }
        }
        
        Thread[] threads = new Thread[threadCount];
        for (int i = 0; i < threadCount; i++) {
            Semaphore currSemaphore = semaphores[i];
            Semaphore lastSemaphore = i == 0 ? semaphores[threadCount - 1] : semaphores[i - 1];
            threads[i] = new Thread(new OrderPrinter(threadCount, maxNum, i, currSemaphore, lastSemaphore), "thread-" + i);
        }
        
        for (int i = 0; i < threadCount; i++) {
            threads[i].start();
        }
        
    }
    
    static class OrderPrinter implements Runnable {
        
        private int threadCount;
        private int maxNum;
        private int threadNo;
        private Semaphore currSemaphore;
        private Semaphore lastSemaphore;
        
        public OrderPrinter(int threadCount, int maxNum, int threadNo, Semaphore currSemaphore, Semaphore lastSemaphore) {
            this.threadCount = threadCount;
            this.maxNum = maxNum;
            this.threadNo = threadNo;
            this.currSemaphore = currSemaphore;
            this.lastSemaphore = lastSemaphore;
        }
        
        @Override
        public void run() {
            while (VALUE < maxNum) {
                try {
                    lastSemaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + " : " + VALUE);
                    VALUE++;
                    if (VALUE >= maxNum) {
                        System.exit(0);
                    }
                    currSemaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    Thread.currentThread().interrupt();
                }
            }
        }
    }
    
    public static void main(String[] args) throws InterruptedException {
        new MultiThreadOrderPrinterSemaphore(4, 100).print();
    }
}
