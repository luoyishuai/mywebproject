package com.yishuailuo.mywebproject.mytest.designpattern.proxy.cgligdynamicproxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by luoyishuai on 17/6/12.
 */
public class CGLibProxy implements MethodInterceptor {

    private static CGLibProxy cgLibProxy = new CGLibProxy();

    public static CGLibProxy getInstance() {
        return cgLibProxy;
    }

    @SuppressWarnings("unchecked")
    public <T> T getProxy(Class<T> cls) {
        return (T) Enhancer.create(cls, this);
    }

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        before();
        Object result = methodProxy.invokeSuper(obj, args);
        after();
        return result;
    }

    private void before() {
        System.out.println("before");
    }

    private void after() {
        System.out.println("after");
    }

}
