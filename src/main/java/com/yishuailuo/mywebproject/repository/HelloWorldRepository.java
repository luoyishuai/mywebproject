package com.yishuailuo.mywebproject.repository;

import org.springframework.stereotype.Repository;

/**
 * Created by luoyishuai on 17/7/17.
 */
@Repository
public class HelloWorldRepository {

    public String get() {
        return "hello world from repository.";
    }
}
