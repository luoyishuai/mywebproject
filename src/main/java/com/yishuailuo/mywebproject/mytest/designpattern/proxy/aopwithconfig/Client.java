package com.yishuailuo.mywebproject.mytest.designpattern.proxy.aopwithconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by luoyishuai on 17/6/13.
 */
public class Client {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Hello hello = (Hello)applicationContext.getBean("helloProxy");
        hello.say("bob");
    }
}
