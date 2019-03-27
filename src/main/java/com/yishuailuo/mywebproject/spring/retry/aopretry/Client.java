package com.yishuailuo.mywebproject.spring.retry.aopretry;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {
    
    public static void main(String[] args) {
        String classpath = "applicationContext-aopretry.xml";
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(classpath);
        UserServiceImpl userService = (UserServiceImpl) applicationContext.getBean("userServiceImpl");
        userService.addUser();
    }
}
