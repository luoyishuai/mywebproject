package com.yishuailuo.mywebproject.concurrency.oddevenprint;

public class MultiThreadOrderPrinter {
    
    private static volatile int VALUE = 0;
    
    private int threadCount;
    private int maxNum;
    
    public MultiThreadOrderPrinter(int threadCount, int maxNum) {
        this.threadCount = threadCount;
        this.maxNum = maxNum;
    }
    
    public void print() {
        for (int i = 0; i <= threadCount; i++) {
            new Thread(new OrderPrinter(threadCount, maxNum, i), "thread-" + i).start();
        }
    }
    
    static class OrderPrinter implements Runnable {
        
        private int threadCount;
        private int maxNum;
        private int threadNo;
        
        public OrderPrinter(int threadCount, int maxNum, int threadNo) {
            this.threadCount = threadCount;
            this.maxNum = maxNum;
            this.threadNo = threadNo;
        }
        
        @Override
        public void run() {
            while (VALUE < maxNum) {
                synchronized (MultiThreadOrderPrinter.class) {
                    if (VALUE % threadCount == threadNo) {
                        System.out.println(Thread.currentThread().getName() + " : " + VALUE);
                        VALUE++;
                        if (VALUE >= maxNum) {
                            System.exit(0);
                        }
                        MultiThreadOrderPrinter.class.notifyAll();
                    }
                    try {
                        MultiThreadOrderPrinter.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }
    }
    
    public static void main(String[] args) {
        new MultiThreadOrderPrinter(3, 100).print();
    }
}
