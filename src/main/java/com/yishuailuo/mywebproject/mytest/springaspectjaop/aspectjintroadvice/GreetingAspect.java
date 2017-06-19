package com.yishuailuo.mywebproject.mytest.springaspectjaop.aspectjintroadvice;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;

/**
 * Created by luoyishuai on 17/6/19.
 */
@Aspect
@Component
public class GreetingAspect {

    @DeclareParents(value = "com.yishuailuo.mywebproject.mytest.springaspectjaop.aspectjintroadvice.GreetingImpl",
            defaultImpl = ApologyImpl.class)
    private Apology apology;
}
