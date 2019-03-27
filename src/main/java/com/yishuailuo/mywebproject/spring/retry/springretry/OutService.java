package com.yishuailuo.mywebproject.spring.retry.springretry;

import org.springframework.stereotype.Component;

@Component
public class OutService {
    
    public void addServiceOut() {
        System.out.println("OutService.addServiceOut()");
        throw new RuntimeException();
    }
}
