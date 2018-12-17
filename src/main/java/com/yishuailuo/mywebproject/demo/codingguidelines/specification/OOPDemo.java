package com.yishuailuo.mywebproject.demo.codingguidelines.specification;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class OOPDemo {
    
    public static void main(String[] args) {
        
        // System.out.println(Objects.equals(null, null));
        
        // testVarargs();
        testInteger();
        // testNPE();
        // testString();
        // testHashCode()
        // testHashCode();
        // testCountDownLatch();
        // testRandom();
    }
    
    private static void testRandom() {
        Random random = new Random(); // seed 为 System.currentTimeMillis()
        System.out.println(random.nextInt(100)); // AtomicLong
    
    
        ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
        System.out.println(threadLocalRandom.nextInt(100));
        
        
    }
    
    private static void testCountDownLatch() {
        // http://zapldy.iteye.com/blog/746458
    }
    
    private static void testHashCode() {
        
        Person personA = new Person("A", 1);
        Person personB = new Person("A", 1);
        System.out.println(personA.hashCode());
        System.out.println(personB.hashCode());
        System.out.println(personB.equals(personA));
        
        // http://www.cnblogs.com/skywang12345/p/3324958.html
        // http://blog.csdn.net/zuiwuyuan/article/details/40340355
    }
    
    private static void testClone() {
        // http://blog.csdn.net/zhangjg_blog/article/details/18369201
        // 因为如果不继承自Cloneable接口，当调用clone()时会抛出CloneNotSupportedException异常
        
    }
    
    private static void testString() {
        // String a = "aaa";
        // String b = "aaa";
        // String c = a;
        // String a = new String("aaa");
        // String b = new String("aaa");
        // String c = a;
        // System.out.println(a==b);
        // System.out.println(a==c);
        // System.out.println(b==c);
        
        String str1 = "str";
        String str2 = "ing";
        
        String str3 = "str" + "ing";
        String str4 = str1 + str2;
        String str5 = str1 + str2;
        String str6 = "str" + "ing";
        System.out.println(str3 == str4);
        System.out.println(str5 == str4);
        System.out.println(str3 == str6);
        
    }
    
    private static void testNPE() {
        int a = (Integer) null;
        System.out.println(a);
    }
    
    private static void testInteger() {
        Integer a = 128;
        Integer b = 128;
        System.out.println(a == b);
        
        // -XX:AutoBoxCacheMax=130
        // HotSpot VM所接收的特定的VM参数都是通过-XX:前缀的命令行参数指定的，而传给Java层的system property则是通过-D前缀的参数来指定
        
        // java.lang.System.initProperties() -D参数都拿到System.properties
        // sun.misc.VM.saveAndRemoveProperties()从System.properties移除一些只供JDK内部使用、
        // 用户代码不应该看到的系统属性，例如设置NIO direct memory大小限制的sun.nio.MaxDirectMemorySize属性
        
    }
    
    private static void testVarargs() {
        someMethodWithVarargs(1, "bbb", "ccc");
    }
    
    private static void someMethodWithVarargs(Integer a, String... strs) {
        System.out.println(strs);
    }
    
}
