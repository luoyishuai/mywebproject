package com.yishuailuo.mywebproject.prototypebeaninjectionproblem.getbean;

import lombok.extern.slf4j.Slf4j;
import org.joda.time.LocalTime;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
public class SingletonBean {
    
    @Autowired
    private SingletonAppContextBean singletonAppContextBean;
    
    public SingletonBean() {
        System.out.println("Singleton instance created");
    }
    
    public PrototypeBean getPrototypeBean() {
        System.out.println(String.valueOf(LocalTime.now()));
        return singletonAppContextBean.getPrototypeBean();
    }
}
