package com.yishuailuo.mywebproject.spring.retry.springretry;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {
    
    public static void main(String[] args) {
        
        // spring retry 两大局限：1. 职能针对异常进行重试，没法根据返回码重试；2.recover 只用于 1 个方法
        String classPath = "applicationContext-springretry.xml";
        ClassPathXmlApplicationContext  applicationContext = new ClassPathXmlApplicationContext(classPath);
        UserServiceImpl userServiceImpl = applicationContext.getBean("userServiceImpl", UserServiceImpl.class);
        userServiceImpl.addUser();
    }
}
