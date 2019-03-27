package com.yishuailuo.mywebproject.spring.retry.implretry;

import org.springframework.stereotype.Component;

public class OutService {

    public void addServiceOut() {
        System.out.println("OutService.addServiceOut()");
        throw new RuntimeException();
    }
}
