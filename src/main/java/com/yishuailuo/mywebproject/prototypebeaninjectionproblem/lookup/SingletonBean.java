package com.yishuailuo.mywebproject.prototypebeaninjectionproblem.lookup;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class SingletonBean {
    
    public SingletonBean() {
        System.out.println("Singleton instance created");
    }
    
    @Lookup
    public PrototypeBean getPrototypeBean() {
        return null;
    }
}
