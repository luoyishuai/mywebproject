package com.yishuailuo.mywebproject.spring.retry.staticproxyretry;

public class UserServiceProxy implements UserService {
    
    private UserService userService;
    
    public UserServiceProxy(UserService userService) {
        this.userService = userService;
    }
    
    @Override
    public void addUser() {
        int maxAttempts = 3;
        int attempts = 0;
        while (attempts < maxAttempts) {
            try {
                userService.addUser();
                return;
            } catch (Exception e) {
                attempts++;
                System.out.println("attempts:" + attempts);
                if (attempts >= maxAttempts) {
                    throw e;
                }
            }
        }
        System.out.println("UserServiceProxy.addUser()");
    }
}
