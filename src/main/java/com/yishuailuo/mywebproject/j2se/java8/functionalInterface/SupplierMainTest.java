package com.yishuailuo.mywebproject.j2se.java8.functionalInterface;

import java.util.function.Supplier;

public class SupplierMainTest {
    public static void main(String[] args) {
        //简写
        Supplier<String> supplier1 = () -> "Test supplier";
        System.out.println(supplier1.get());
    
        //标准格式
        Supplier<Integer> supplier2 = () -> {
            return 20;
        };
        System.out.println(supplier2.get() instanceof Integer);
    }
}
