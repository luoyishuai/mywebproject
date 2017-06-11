package com.yishuailuo.mywebproject.mytest.designpattern.proxy.staticproxy;

/**
 * Created by luoyishuai on 17/6/12.
 */
public class MainTest {

    public static void main(String[] args) {
        Hello hello = new HelloImpl();
        HelloProxy helloProxy = new HelloProxy(hello);
        helloProxy.say("jack");
    }
}
