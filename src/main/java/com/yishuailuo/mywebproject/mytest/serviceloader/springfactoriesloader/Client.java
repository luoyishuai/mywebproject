package com.yishuailuo.mywebproject.mytest.serviceloader.springfactoriesloader;

import org.springframework.core.io.support.SpringFactoriesLoader;

import java.util.List;

public class Client {
    
    public static void main(String[] args) {
    
        List<IService> serviceList = SpringFactoriesLoader.loadFactories(IService.class, null);
        for (IService service : serviceList) {
            service.sayHello();
        }
    }
}
