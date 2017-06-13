package com.yishuailuo.mywebproject.mytest.designpattern.proxy.aopwitharoundadvice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * Created by luoyishuai on 17/6/13.
 */
public class HelloAroundAdvice implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {

        before();
        Object result = methodInvocation.proceed();
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
