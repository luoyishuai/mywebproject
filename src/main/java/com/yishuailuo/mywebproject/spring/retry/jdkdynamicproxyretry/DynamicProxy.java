package com.yishuailuo.mywebproject.spring.retry.jdkdynamicproxyretry;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxy implements InvocationHandler {
    
    private Object subject;
    
    public DynamicProxy(Object subject) {
        this.subject = subject;
    }
    
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        int maxAttempts = 3;
        int attempts = 0;
        while (attempts < maxAttempts) {
            try {
                method.invoke(subject, args);
                return null;
            } catch (Exception e) {
                attempts++;
                System.out.println("attempts:" + attempts);
                if (attempts >= maxAttempts) {
                    throw e;
                }
            }
        }
        System.out.println("UserServiceProxy.addUser()");
        return null;
    }
    
    public static Object createProxy(Object realSubject) {
        InvocationHandler invocationHandler = new DynamicProxy(realSubject);
        return (Object) Proxy.newProxyInstance(realSubject.getClass().getClassLoader(), realSubject.getClass().getInterfaces(), invocationHandler);
    }
}
