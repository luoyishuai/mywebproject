package com.yishuailuo.mywebproject.mytest.designpattern.singleton.five;

import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public class Singleton {

    private static Singleton singleton;
    
    private Singleton() {}
    
    private static synchronized Singleton getSingleton() {
        if (singleton == null) {
            singleton = new Singleton();
        }
        return singleton;
    }
}
