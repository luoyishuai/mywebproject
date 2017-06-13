package com.yishuailuo.mywebproject.mytest.designpattern.proxy.aopwitharoundadvice;

import org.springframework.aop.framework.ProxyFactory;

/**
 * Created by luoyishuai on 17/6/13.
 */
public class Client {

    public static void main(String[] args) {
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(new HelloImpl());
        proxyFactory.addAdvice(new HelloAroundAdvice());
        Hello hello = (Hello) proxyFactory.getProxy();
        hello.say("nash");
    }
}
