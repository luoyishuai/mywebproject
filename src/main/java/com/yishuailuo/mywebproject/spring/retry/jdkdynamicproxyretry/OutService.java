package com.yishuailuo.mywebproject.spring.retry.jdkdynamicproxyretry;

public class OutService {
    
    public void addUserOut() {
        System.out.println("OutService.addServiceOut()");
        throw new RuntimeException();
    }
}
