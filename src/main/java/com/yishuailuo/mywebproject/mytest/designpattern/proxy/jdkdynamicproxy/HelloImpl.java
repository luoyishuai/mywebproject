package com.yishuailuo.mywebproject.mytest.designpattern.proxy.jdkdynamicproxy;

/**
 * Created by luoyishuai on 17/6/12.
 */
public class HelloImpl implements Hello {
    @Override
    public void say(String name) {
        System.out.println("hello " + name);
    }
}
