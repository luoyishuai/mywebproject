package com.yishuailuo.mywebproject.spring.retry.staticproxyretry;

public class OutService {

    public void addServiceOut() {
        System.out.println("OutService.addServiceOut()");
        throw new RuntimeException();
    }
}
