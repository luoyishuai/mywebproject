package com.yishuailuo.mywebproject.spring.retry.cglibdynamicproxyretry;

public class OutService {
    
    public void addUserOut() {
        System.out.println("OutService.addServiceOut()");
        throw new RuntimeException();
    }
}
