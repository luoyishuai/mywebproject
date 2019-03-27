package com.yishuailuo.mywebproject.j2se.java8.functionalInterface;

import java.util.function.Predicate;

public class PredicateMainTest {
    public static void main(String[] args) {
        Predicate<String> predicate = (x) -> x.length() > 0;
        System.out.println(predicate.test("String"));
    }
}
