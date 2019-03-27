package com.yishuailuo.mywebproject.dynamicproxy.jdk;

import java.lang.reflect.Proxy;

public class Client {
    public static void main(String[] args) {
        HelloWorld helloWorld = (HelloWorld) Proxy.newProxyInstance(
                Client.class.getClassLoader(), new Class[]{HelloWorld.class},
                new HelloWorldProxy(new HelloWorldImpl()));
        helloWorld.sayHelloWorld();
    }
}
