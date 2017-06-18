package com.yishuailuo.mywebproject.mytest.springaop.advisor;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.stereotype.Component;

/**
 * Created by luoyishuai on 17/6/18.
 */
@Component
public class GreetingAroundAdvice implements org.aopalliance.intercept.MethodInterceptor {


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
