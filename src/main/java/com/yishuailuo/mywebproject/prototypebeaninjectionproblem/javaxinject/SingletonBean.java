package com.yishuailuo.mywebproject.prototypebeaninjectionproblem.javaxinject;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.inject.Provider;

@Component
@Slf4j
public class SingletonBean {
    
    @Autowired
    private Provider<PrototypeBean> prototypeBeanProvider;
    
    public SingletonBean() {
        System.out.println("Singleton instance created");
    }
    
    public PrototypeBean getPrototypeBean() {
        return prototypeBeanProvider.get();
    }
}
