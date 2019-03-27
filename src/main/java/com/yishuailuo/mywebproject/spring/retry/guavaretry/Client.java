package com.yishuailuo.mywebproject.spring.retry.guavaretry;

public class Client {
    
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl(new OutService());
        userService.addUser();
    }
}
