package com.yishuailuo.mywebproject.mytest.designpattern.singleton.two;

import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public class Singleton {
    
    private static class SingletonResource {
        private static Singleton singleton = new Singleton();
    }
    
    private Singleton() {}
    
    public static Singleton getSingleton() {
        return SingletonResource.singleton;
    }
}
