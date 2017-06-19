package com.yishuailuo.mywebproject.mytest.springaspectjaop.aspectjwithtag;

import org.springframework.stereotype.Component;

/**
 * Created by luoyishuai on 17/6/19.
 */
@Component
public class GreetingImpl implements Greeting {

    @Tag
    @Override
    public void sayHello(String name) {
        System.out.println("hello " + name);
    }
}
