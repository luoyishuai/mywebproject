package com.yishuailuo.mywebproject.prototypebeaninjectionproblem.annotationonly;

import lombok.extern.slf4j.Slf4j;
import org.joda.time.LocalTime;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
public class SingletonBean {
 
    @Autowired
    private PrototypeBean prototypeBean;
    
    public SingletonBean() {
        System.out.println("Singleton instance created");
    }
    
    public PrototypeBean getPrototypeBean() {
        System.out.println(String.valueOf(LocalTime.now()));
        return prototypeBean;
    }
}
