package com.yishuailuo.mywebproject.mytest.springaspectjaop.aspectjwithtag;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * Created by luoyishuai on 17/6/19.
 */
@Aspect
@Component
public class GreetingAspect {

    @Around("@annotation(com.yishuailuo.mywebproject.mytest.springaspectjaop.aspectjwithtag.Tag)")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        before();
        Object result = pjp.proceed();
        after();
        return result;
    }

    public void before() {
        System.out.println("before");
    }

    public void after() {
        System.out.println("after");
    }
}
