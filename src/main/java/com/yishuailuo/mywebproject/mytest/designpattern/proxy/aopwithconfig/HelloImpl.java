package com.yishuailuo.mywebproject.mytest.designpattern.proxy.aopwithconfig;

import org.springframework.stereotype.Component;

/**
 * Created by luoyishuai on 17/6/13.
 */
@Component
public class HelloImpl implements Hello {
    @Override
    public void say(String name) {
        System.out.println("hello " + name);
    }
}
