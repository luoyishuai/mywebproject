package com.yishuailuo.mywebproject.spring.retry.implretry;

public class Client {
    
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl(new OutService());
        userService.addUser();
    }
}
