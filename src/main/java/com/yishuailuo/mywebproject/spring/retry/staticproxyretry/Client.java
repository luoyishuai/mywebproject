package com.yishuailuo.mywebproject.spring.retry.staticproxyretry;

public class Client {
    
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl(new OutService());
        UserServiceProxy userServiceProxy = new UserServiceProxy(userService);
        userServiceProxy.addUser();
    }
}
