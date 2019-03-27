package com.yishuailuo.mywebproject.j2se.java8.functionalInterface;

import java.util.function.Consumer;

public class ConsumerMainTest {
    
    public static void main(String[] args) {
        Consumer<String> consumer1 = (x) -> System.out.println(x);
        Consumer<String> consumer2 = (x) -> {
            System.out.println(" after consumer 1");
        };
        consumer1.andThen(consumer2).accept("test consumer1");
    }
}
