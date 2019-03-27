package com.yishuailuo.mywebproject.spring.retry.jdkdynamicproxyretry;

public class Client {
    
    public static void main(String[] args) {
        UserService userService = (UserService) DynamicProxy.createProxy(new UserServiceImpl(new OutService()));
        userService.addUser();
    }
}
