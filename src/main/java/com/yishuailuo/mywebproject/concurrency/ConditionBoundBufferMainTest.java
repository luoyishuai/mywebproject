package com.yishuailuo.mywebproject.concurrency;

import java.util.concurrent.TimeUnit;

public class ConditionBoundBufferMainTest {
    
    public static void main(String[] args) throws InterruptedException {
        final ConditionBoundBuffer<Integer> stringBoundBuffer = new ConditionBoundBuffer<>();
        
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i < 100; i++) {
                    stringBoundBuffer.put(i);
                }
            }
        }).start();
    
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i < 200; i++) {
                    try {
                        stringBoundBuffer.take();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }).start();
        TimeUnit.MINUTES.sleep(2);
    }
    
}
