package com.yishuailuo.mywebproject.mytest.designpattern.singleton.four;

import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public class Singleton {
    
    private static volatile Singleton singleton;
    
    private Singleton() {}
    
    public static Singleton getSingleton() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                   
                    singleton = new Singleton();
                }
            }
        }
        // 上述 new Singleton() 非原子性，但由于 singleton 加了 volatile 保证可见性和防止指令重排序
        // 这里返回的 singleton 是构造好的 singleton，线程安全
        return singleton;
    }
}
