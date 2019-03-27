package com.yishuailuo.mywebproject.spring.retry.aopretry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl {
    
    @Autowired
    private OutService outService;
    
    @Retryable(maxAttempts = 6)
    public void addUser() {
        outService.addServiceOut();
        System.out.println("UserServiceImpl.addUser()");
    }
}
