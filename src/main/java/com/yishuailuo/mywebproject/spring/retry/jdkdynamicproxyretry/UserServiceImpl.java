package com.yishuailuo.mywebproject.spring.retry.jdkdynamicproxyretry;

public class UserServiceImpl implements UserService {
    
    private OutService outService;
    
    public UserServiceImpl(OutService outService) {
        this.outService = outService;
    }
    
    @Override
    public void addUser() {
        outService.addUserOut();
        System.out.println("UserServiceImpl.addUser()");
    }
}
