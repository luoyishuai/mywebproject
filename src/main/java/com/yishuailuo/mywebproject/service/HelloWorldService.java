package com.yishuailuo.mywebproject.service;

import org.springframework.stereotype.Service;

/**
 * Created by luoyishuai on 17/6/4.
 */
@Service
public class HelloWorldService {

    public String returnWelcome(){
        return "Welcome!";
    }
}
