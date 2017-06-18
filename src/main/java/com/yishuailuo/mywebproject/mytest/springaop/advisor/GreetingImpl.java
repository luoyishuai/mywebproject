package com.yishuailuo.mywebproject.mytest.springaop.advisor;

import org.springframework.stereotype.Component;

/**
 * Created by luoyishuai on 17/6/18.
 */
@Component
public class GreetingImpl implements Greeting {
    @Override
    public void sayHello(String name) {
        System.out.println("hello " + name);
    }

    public void goodMorning(String name) {
        System.out.println("good morning " + name);
    }

    public void goodNight(String name) {
        System.out.println("good night " + name);
    }
}
