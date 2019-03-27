package com.yishuailuo.mywebproject.j2se.java8.functionalInterface;

import java.util.function.Function;

public class FunctionMainTest {
    
    public static void main(String[] args) {
        Function<Integer, String> function1 = (x) -> "test result: " + x;
    
        //标准的,有花括号, return, 分号.
        Function<String, String> function2 = (x) -> {
            return "after function1";
        };
        System.out.println(function1.apply(6));
        System.out.println(function1.andThen(function2).apply(6));
    }
}
