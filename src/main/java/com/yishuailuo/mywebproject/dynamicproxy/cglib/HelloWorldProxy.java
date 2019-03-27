package com.yishuailuo.mywebproject.dynamicproxy.cglib;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class HelloWorldProxy implements MethodInterceptor {
    
    private HelloWorldImpl helloWorldImpl;
    
    public HelloWorldProxy(HelloWorldImpl helloWorldImpl) {
        this.helloWorldImpl = helloWorldImpl;
    }
    
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("method " + method.getName() + " is invoked!");
        methodProxy.invokeSuper(o, objects);
        return null;
    }
}
