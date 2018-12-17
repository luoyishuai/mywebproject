package com.yishuailuo.mywebproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClassB {
    
    @Autowired
    private InterfaceA interfaceA;
    
    
}
