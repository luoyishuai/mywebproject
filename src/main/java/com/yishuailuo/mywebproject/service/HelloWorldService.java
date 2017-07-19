package com.yishuailuo.mywebproject.service;

import com.yishuailuo.mywebproject.domain.HelloWorld;
import com.yishuailuo.mywebproject.mapper.HelloWorldMapper;
import com.yishuailuo.mywebproject.mytest.designpattern.proxy.jdkdynamicproxy.Hello;
import com.yishuailuo.mywebproject.repository.HelloWorldRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by luoyishuai on 17/6/4.
 */
@Service
public class HelloWorldService {

    @Autowired
    private HelloWorldRepository helloWorldRepository;

    @Autowired
    private HelloWorldMapper helloWorldMapper;

    public String returnWelcome() {
        return helloWorldRepository.get();
    }

    public String getHelloWorldDesc(String name) {
        return helloWorldMapper.getByName(name).getNameDesc();
    }


    public HelloWorld add(HelloWorld helloWorld) {
        helloWorldMapper.add(helloWorld);
        return helloWorldMapper.get(helloWorld);
    }

    public Integer delete(HelloWorld helloWorld) {
        return helloWorldMapper.delete(helloWorld);
    }

}
