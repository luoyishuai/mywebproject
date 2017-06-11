package com.yishuailuo.mywebproject.mytest.designpattern.proxy.staticproxy;

/**
 * Created by luoyishuai on 17/6/12.
 */
public class HelloProxy {

    private Hello hello;

    public HelloProxy(Hello hello) {
        this.hello = hello;
    }

    public void say(String name) {
        before();
        hello.say(name);
        after();
    }

    private void before() {
        System.out.println("before");
    }

    private void after() {
        System.out.println("after");
    }


}
