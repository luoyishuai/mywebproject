package com.yishuailuo.mywebproject.mytest.serviceloader.originalserviceloader;

import java.util.ServiceLoader;

public class Client {
    
    public static void main(String[] args) {
        ServiceLoader<IService> serviceLoader = ServiceLoader.load(IService.class);
        for (IService iService : serviceLoader) {
            iService.sayHello();
        }
    }
}
