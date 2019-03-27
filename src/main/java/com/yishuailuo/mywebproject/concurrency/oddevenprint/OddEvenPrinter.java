package com.yishuailuo.mywebproject.concurrency.oddevenprint;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class OddEvenPrinter {
    
    private static volatile int value = 0;
    
    static class PrintValue implements Runnable {
        @Override
        public void run() {
            while (value < 100) {
                synchronized (OddEvenPrinter.class) {
                    System.out.println(Thread.currentThread().getName() + " : " + value++);
                    OddEvenPrinter.class.notify();
                    try {
                        OddEvenPrinter.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }
    }
    
    public static void main(String[] args) {
        new Thread(new PrintValue(), " Odd").start();
        new Thread(new PrintValue(), "Even").start();
    }
}
