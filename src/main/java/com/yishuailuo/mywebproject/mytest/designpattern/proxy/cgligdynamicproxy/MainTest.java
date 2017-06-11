package com.yishuailuo.mywebproject.mytest.designpattern.proxy.cgligdynamicproxy;

/**
 * Created by luoyishuai on 17/6/12.
 */
public class MainTest {

    public static void main(String[] args) {
        Hello helloProxy = CGLibProxy.getInstance().getProxy(HelloImpl.class);
        helloProxy.say("james");
    }
}
