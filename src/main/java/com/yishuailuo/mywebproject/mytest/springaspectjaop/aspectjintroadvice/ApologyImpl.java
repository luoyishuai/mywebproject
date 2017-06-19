package com.yishuailuo.mywebproject.mytest.springaspectjaop.aspectjintroadvice;

import org.springframework.stereotype.Component;

/**
 * Created by luoyishuai on 17/6/19.
 */
@Component
public class ApologyImpl implements Apology {

    @Override
    public void saySorry(String name) {
        System.out.println("sorry " + name);
    }
}
