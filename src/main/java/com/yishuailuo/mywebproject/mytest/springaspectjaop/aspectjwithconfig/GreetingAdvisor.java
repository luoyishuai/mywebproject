package com.yishuailuo.mywebproject.mytest.springaspectjaop.aspectjwithconfig;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
/**
 * Created by luoyishuai on 17/6/18.
 */

@Aspect
@Component
public class GreetingAdvisor {

    @Around("execution(* com.yishuailuo.mywebproject.mytest.springaspectjaop.aspectjwithconfig.GreetingImpl.*(..))")
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
