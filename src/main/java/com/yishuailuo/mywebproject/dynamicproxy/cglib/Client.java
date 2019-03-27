package com.yishuailuo.mywebproject.dynamicproxy.cglib;

import org.springframework.cglib.proxy.Enhancer;

public class Client {
    
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(HelloWorldImpl.class);
        enhancer.setCallback(new HelloWorldProxy(new HelloWorldImpl()));
        HelloWorldImpl helloWorld = (HelloWorldImpl) enhancer.create();
        helloWorld.sayHelloWorld();
    }
}
