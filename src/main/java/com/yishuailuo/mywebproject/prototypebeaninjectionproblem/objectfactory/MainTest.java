package com.yishuailuo.mywebproject.prototypebeaninjectionproblem.objectfactory;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainTest {
    
    public static void main(String[] args) throws InterruptedException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        
        SingletonBean firstSingleton = context.getBean(SingletonBean.class);
        PrototypeBean firstPrototype = firstSingleton.getPrototypeBean();
        
        SingletonBean secondSingleton = context.getBean(SingletonBean.class);
        PrototypeBean secondPrototype = secondSingleton.getPrototypeBean();
        
        if (firstPrototype.equals(secondPrototype)) {{
            System.out.println("same instance. firstPrototype=" + firstPrototype + " secondPrototype=" + secondPrototype);
        }
            System.out.println("same instance. firstPrototype=" + firstPrototype + " secondPrototype=" + secondPrototype);
        } else {
            System.out.println("different instance. firstPrototype=" + firstPrototype + " secondPrototype=" + secondPrototype);
        }
        
    }
}
