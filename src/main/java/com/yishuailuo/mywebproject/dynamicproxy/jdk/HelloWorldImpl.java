package com.yishuailuo.mywebproject.dynamicproxy.jdk;

public class HelloWorldImpl implements HelloWorld {
    
    @Override
    public void sayHelloWorld() {
        System.out.println("hello world!");
    }
}
