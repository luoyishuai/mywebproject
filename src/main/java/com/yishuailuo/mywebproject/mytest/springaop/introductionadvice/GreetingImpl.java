package com.yishuailuo.mywebproject.mytest.springaop.introductionadvice;

import org.springframework.stereotype.Component;

/**
 * Created by luoyishuai on 17/6/18.
 */
@Component
public class GreetingImpl implements Greeting{
    @Override
    public void sayHello(String name) {
        System.out.println("hello " + name);
    }
}
