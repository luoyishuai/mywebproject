package com.yishuailuo.mywebproject.spring.retry.aopretry;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class RetryAspect {
    
    public void retry(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        
        Method method = getCurrentMethod(proceedingJoinPoint);
    
        Annotation annotation = method.getAnnotation(Retryable.class);
        if (annotation != null) {
            
            Retryable retryable =  ((Retryable)annotation);
            int maxAttempts = retryable.maxAttempts();
            Class<? extends Throwable> clazz = retryable.value();
            int attempts = 0;
            while (attempts < maxAttempts) {
                try {
                    proceedingJoinPoint.proceed();
                    return;
                } catch (Throwable e) {
                    if (attempts >= maxAttempts || !e.getClass().isAssignableFrom(clazz)) {
                        throw e;
                    }
                    attempts++;
                    System.out.println("attempts:" + attempts);
                }
            }
            System.out.println("UserServiceProxy.addUser()");
        }
        return;
    }
    
    private Method getCurrentMethod(ProceedingJoinPoint proceedingJoinPoint) {
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
        Object target = proceedingJoinPoint.getTarget();
        try {
            return target.getClass().getMethod(methodSignature.getName(), methodSignature.getParameterTypes());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
