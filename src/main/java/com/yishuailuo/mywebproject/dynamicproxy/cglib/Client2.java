package com.yishuailuo.mywebproject.dynamicproxy.cglib;


public class Client2 {
    
    public static void main(String[] args) {
        CglibProxy cglibProxy = new CglibProxy();
        HelloWorldImpl helloWorld = (HelloWorldImpl) cglibProxy.getProxy(HelloWorldImpl.class);
        helloWorld.sayHelloWorld();
    }
}
