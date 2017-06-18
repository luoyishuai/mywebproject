package com.yishuailuo.mywebproject.mytest.springaspectjaop.aspectjwithconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by luoyishuai on 17/6/18.
 */
public class Client {

    public static void main(String[] args) {
        String applicationContextFilePath = "applicationContext-aspectjwithconfig.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(applicationContextFilePath);
//        GreetingImpl greeting = (GreetingImpl) applicationContext.getBean("greetingProxy");
        GreetingImpl greeting = (GreetingImpl) applicationContext.getBean("greetingImpl");
        greeting.sayHello("mook");
    }
}
