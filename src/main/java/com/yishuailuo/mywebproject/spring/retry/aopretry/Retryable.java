package com.yishuailuo.mywebproject.spring.retry.aopretry;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(value = ElementType.METHOD)
public @interface Retryable {
    
    Class<? extends Throwable> value() default RuntimeException.class;
    
    int maxAttempts() default 5;
}
