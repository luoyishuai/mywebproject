package com.yishuailuo.mywebproject.prototypebeaninjectionproblem.annotationonly;

import com.yishuailuo.mywebproject.prototypebeaninjectionproblem.getbean.SingletonAppContextBean;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {
    
    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public PrototypeBean prototypeBean() {
        return new PrototypeBean();
    }
    
    @Bean
    public SingletonBean singletonBean() {
        return new SingletonBean();
    }
    
    @Bean
    public SingletonAppContextBean singletonAppContextBean() {
        return new SingletonAppContextBean();
    }
}
