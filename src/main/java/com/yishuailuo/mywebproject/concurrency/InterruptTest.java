package com.yishuailuo.mywebproject.concurrency;

import java.util.concurrent.TimeUnit;

public class InterruptTest {
    
    public static void main(String[] args) {
        CountThread countThread = new CountThread();
        countThread.start();
        try {
            TimeUnit.MILLISECONDS.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 主线程主动中断 countThread 线程
        countThread.interrupt();
    }
}

class CountThread extends Thread {
    
    @Override
    public void run() {
        try {
            for (int i = 0; i < 100000; i ++) {
                 /*优雅地处理中断的方式为：循环的线程内部先检查中断再开始循环
                 如果检查到线程中断，则抛出 InterruptedException 异常*/
                if (this.isInterrupted()) {
                    throw new InterruptedException();
                }
                System.out.println("i:" + i);
            }
        } catch (InterruptedException e) {
            /* 由于 run() 方法是继承来的，无法再写 throws 子句抛出 InterruptedException 异常，
               所以应该主动 interrupt 线程，以便外部捕获中断从而进行处理
               
               如果不能重新抛出 InterruptedException，不管您是否计划处理中断请求，仍然需要重新中断当前线程，
               因为一个中断请求可能有多个 “接收者”。标准线程池 （ThreadPoolExecutor）worker 线程实现负责中断，
               因此中断一个运行在线程池中的任务可以起到双重效果，一是取消任务，二是通知执行线程线程池正要关闭。
               如果任务生吞中断请求，则 worker 线程将不知道有一个被请求的中断，从而耽误应用程序或服务的关闭。
               
             */
            Thread.currentThread().interrupt();
        }
    }
}
