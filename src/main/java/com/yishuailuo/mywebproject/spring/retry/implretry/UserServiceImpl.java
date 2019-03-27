package com.yishuailuo.mywebproject.spring.retry.implretry;

public class UserServiceImpl implements UserService {
    
    private OutService outService;
    
    public UserServiceImpl(OutService outService) {
        this.outService = outService;
    }
    
    @Override
    public void addUser() {
        int maxAttempts = 3;
        int attempts = 0;
        while (attempts < maxAttempts) {
            try {
                outService.addServiceOut();
                return;
            } catch (Exception e) {
                attempts++;
                System.out.println("attempts:" + attempts);
                if (attempts >= maxAttempts) {
                    throw e;
                }
            }
        }
        System.out.println("UserServiceImpl.addUser()");
    }
}
