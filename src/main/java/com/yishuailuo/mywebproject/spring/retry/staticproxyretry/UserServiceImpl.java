package com.yishuailuo.mywebproject.spring.retry.staticproxyretry;

public class UserServiceImpl implements UserService {
    
    private OutService outService;
    
    public UserServiceImpl(OutService outService) {
        this.outService = outService;
    }
    
    @Override
    public void addUser() {
        outService.addServiceOut();
        System.out.println("UserServiceImpl.addUser()");
    }
}
