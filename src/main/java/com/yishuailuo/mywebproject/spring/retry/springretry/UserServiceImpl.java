package com.yishuailuo.mywebproject.spring.retry.springretry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl {
    
    @Autowired
    private OutService outService;
    
    @Retryable(maxAttempts = 2, value = RuntimeException.class)
    public void addUser() {
        outService.addServiceOut();
        System.out.println("UserServiceImpl.addUser()");
    }
    
    @Recover
    public void recover(RuntimeException e) {
        System.out.println("recover!");
    }
}
