package com.yishuailuo.mywebproject.spring.retry.cglibdynamicproxyretry;

public class Client {
    
    public static void main(String[] args) {
        UserServiceImpl userServiceImpl = (UserServiceImpl) DynamicProxy.createProxy(new UserServiceImpl(new OutService()));
        userServiceImpl.addUser();
    }
}
