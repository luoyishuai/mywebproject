package com.yishuailuo.mywebproject.spring.retry.cglibdynamicproxyretry;

public class UserServiceImpl {
    
    private OutService outService;
    
    public UserServiceImpl() {}
    
    public UserServiceImpl(OutService outService) {
        this.outService = outService;
    }
    
    public void addUser() {
        outService.addUserOut();
        System.out.println("UserServiceImpl.addUser()");
    }
}
