package com.yishuailuo.mywebproject.mytest.springaspectjaop.aspectjcommonconfig;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * Created by luoyishuai on 17/6/19.
 */
@Aspect
@Component
public class GreetingAspect {

    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        before();
        Object result = pjp.proceed();
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
