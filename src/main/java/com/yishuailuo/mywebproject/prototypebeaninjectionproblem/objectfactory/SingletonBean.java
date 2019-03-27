package com.yishuailuo.mywebproject.prototypebeaninjectionproblem.objectfactory;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class SingletonBean {
    
    @Autowired
    private ObjectFactory<PrototypeBean> prototypeBeanObjectFactory;
    
    public SingletonBean() {
        System.out.println("Singleton instance created");
    }
    
    public PrototypeBean getPrototypeBean() {
        return prototypeBeanObjectFactory.getObject();
    }
}
