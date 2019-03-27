package com.yishuailuo.mywebproject.mytest.designpattern.singleton.seven;

import org.apache.commons.lang3.concurrent.BasicThreadFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public enum Singleton {
    
    /**
     * 仅有一个枚举，如有多个，则构造函数会初始化多次
     *
     */
    INSTANCE;
    
    private final ExecutorService executorService;
    
    /**
     *  重写枚举类默认的私有构造函数，进行初始化的工作
     *
     */
    Singleton() {
        ThreadFactory threadFactory = new BasicThreadFactory.Builder().namingPattern("schedule-pool-%d").daemon(true).build();
        executorService = new ThreadPoolExecutor(5, 200, 0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(1024), threadFactory, new ThreadPoolExecutor.AbortPolicy());
    }
    
    public ExecutorService getExecutorService() {
        return executorService;
    }
    
    
    public static void main(String[] args) {
        for (int i = 0; i< 100; i++) {
            // 尽在 i = 0 时，调用了私有的构造函数 Singleton 进行了 executorService 的初始化
            System.out.println(Singleton.INSTANCE.getExecutorService());
        }
        
    }
}
