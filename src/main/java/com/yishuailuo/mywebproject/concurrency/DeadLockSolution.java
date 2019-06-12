package com.yishuailuo.mywebproject.concurrency;

import java.util.concurrent.TimeUnit;

public class DeadLockSolution {

    static final Object object1 = new Object();
    static final Object object2 = new Object();

    public static void main(String[] args) {

        Thread thread1 = new Thread(new DeadLockThread(true));
        Thread thread2 = new Thread(new DeadLockThread(false));

        thread1.start();
        thread2.start();

    }

    static class DeadLockThread implements Runnable {
        boolean flag;

        DeadLockThread(boolean flag) {
            this.flag = flag;
        }

        @Override
        public void run() {
            if (flag) {
                synchronized (object1) {
                    try {
                        System.out.println("thread1 got object1, flag=" + flag);
                        TimeUnit.SECONDS.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (object2) {
                        System.out.println("thread1 got object2, flag=" + flag);
                    }
                }
            } else {
                synchronized (object2) {
                    try {
                        System.out.println("thread2 got object2, flag=" + flag);
                        TimeUnit.SECONDS.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (object1) {
                        System.out.println("thread2 got object1, flag=" + flag);
                    }
                }
            }
        }
    }
}
