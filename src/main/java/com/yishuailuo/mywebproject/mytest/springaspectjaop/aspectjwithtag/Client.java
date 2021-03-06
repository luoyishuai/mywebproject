package com.yishuailuo.mywebproject.mytest.springaspectjaop.aspectjwithtag;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by luoyishuai on 17/6/19.
 */
public class Client {

    public static void main(String[] args) {

        String applicationContextFilePath = "applicationContext-aspectjwithtag.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(applicationContextFilePath);
        Greeting greeting = (GreetingImpl) applicationContext.getBean("greetingImpl");
        greeting.sayHello("e-dog");
    }
}
