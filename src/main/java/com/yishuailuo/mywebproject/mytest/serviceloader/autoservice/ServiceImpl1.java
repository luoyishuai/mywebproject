package com.yishuailuo.mywebproject.mytest.serviceloader.autoservice;

import com.google.auto.service.AutoService;

@AutoService(IService.class)
public class ServiceImpl1 implements IService {
    @Override
    public void sayHello() {
        System.out.println("hello3");
    }
}
