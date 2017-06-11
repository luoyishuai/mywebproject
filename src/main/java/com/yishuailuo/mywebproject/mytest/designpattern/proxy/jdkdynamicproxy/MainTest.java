package com.yishuailuo.mywebproject.mytest.designpattern.proxy.jdkdynamicproxy;

/**
 * Created by luoyishuai on 17/6/12.
 */
public class MainTest {

    public static void main(String[] args) {
        DynamicProxy dynamicProxy = new DynamicProxy(new HelloImpl());
        Hello helloProxy = dynamicProxy.getProxy();
        helloProxy.say("rose");
    }
}
