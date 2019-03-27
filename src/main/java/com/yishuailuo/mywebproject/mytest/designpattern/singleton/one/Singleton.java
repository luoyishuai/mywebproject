package com.yishuailuo.mywebproject.mytest.designpattern.singleton.one;

import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
public class Singleton {
    
    private Singleton singleton;
    
    private Singleton() {}
    
    public Singleton getSingleton() {
        if (singleton == null) {
            return new Singleton();
        }
        return singleton;
    }
}
