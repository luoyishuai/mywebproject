package com.yishuailuo.mywebproject.mytest.designpattern.proxy.aopwithbeforeandafteradvice;

import org.springframework.aop.framework.ProxyFactory;

/**
 * Created by luoyishuai on 17/6/13.
 */
public class Client {

    public static void main(String[] args) {
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(new HelloImpl());
        proxyFactory.addAdvice(new HelloBeforeAndAfterAdvice());
        Hello hello = (Hello) proxyFactory.getProxy();
        hello.say("sparrow");
    }
}
