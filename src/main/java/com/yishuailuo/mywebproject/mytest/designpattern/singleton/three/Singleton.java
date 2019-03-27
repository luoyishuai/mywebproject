package com.yishuailuo.mywebproject.mytest.designpattern.singleton.three;

public class Singleton {
    
    private static Singleton singleton;
    
    private Singleton() {}
    
    public static Singleton getSingleton() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                   
                    singleton = new Singleton();
                }
            }
        }
        // 上述 new Singleton() 非原子性与指令重排序机制可能导致这里返回未构造完整 singleton
        return singleton;
    }
}
