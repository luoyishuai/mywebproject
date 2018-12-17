package com.yishuailuo.mywebproject.service;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by luoyishuai on 17/7/28.
 */
public final class StaticMethodService {

    private FinalMethodService finalMethodService;

    @Autowired
    public StaticMethodService(FinalMethodService finalMethodService) {
        this.finalMethodService = finalMethodService;
    }

    public static String staticMethod(String str) {
        return str;
    }

    public String methodCallStaticPrivateMethod(String str) {
        return staticMethod(str) + " " + privateMethod(str);
    }

    private String privateMethod(String str) {
        return str;
    }

    public String methodCallFinalMethod(String str) {
        return finalMethodService.finalMethod(str);
    }

}
