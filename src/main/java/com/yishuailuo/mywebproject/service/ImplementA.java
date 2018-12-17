package com.yishuailuo.mywebproject.service;

import org.springframework.stereotype.Component;

@Component
public class ImplementA implements InterfaceA {
    
    @Override
    public void hello() {
        System.out.println("hello world");
    }
}
