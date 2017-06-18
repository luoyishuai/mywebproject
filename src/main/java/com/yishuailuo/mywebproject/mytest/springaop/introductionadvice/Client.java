package com.yishuailuo.mywebproject.mytest.springaop.introductionadvice;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by luoyishuai on 17/6/18.
 */
public class Client {
    public static void main(String[] args) {
        String applicationContextFilePath = "applicationContext-introAdvice.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(applicationContextFilePath);
        GreetingImpl greeting =  (GreetingImpl) applicationContext.getBean("greetingProxy");
        greeting.sayHello("jack");
        Apology apology = (Apology)greeting;
        apology.saySorry("rose");
    }
}
