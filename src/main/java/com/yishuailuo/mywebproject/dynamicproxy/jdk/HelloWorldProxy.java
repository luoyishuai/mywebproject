package com.yishuailuo.mywebproject.dynamicproxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class HelloWorldProxy implements InvocationHandler {
    
    private HelloWorld helloWorld;
    
    public HelloWorldProxy(HelloWorld helloWorld) {
        this.helloWorld = helloWorld;
    }
    
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("method " + method.getName() + " is invoked.");
        helloWorld.sayHelloWorld();
        return null;
    }
}
