package com.yishuailuo.mywebproject.mytest.designpattern.proxy.aopwitharoundadvice;

/**
 * Created by luoyishuai on 17/6/13.
 */
public class HelloImpl implements Hello{

    @Override
    public void say(String name) {
        System.out.println("hello " + name);
    }
}
