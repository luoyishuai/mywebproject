package com.yishuailuo.mywebproject.spring.retry.cglibdynamicproxyretry;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class DynamicProxy implements MethodInterceptor {
    
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        int maxAttempts = 3;
        int attempts = 0;
        while (attempts < maxAttempts) {
            try {
                methodProxy.invokeSuper(o, objects);
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
    
    public static Object createProxy(Object readSubject) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(readSubject.getClass());
        enhancer.setCallback(new DynamicProxy());
        return enhancer.create();
    }
}
