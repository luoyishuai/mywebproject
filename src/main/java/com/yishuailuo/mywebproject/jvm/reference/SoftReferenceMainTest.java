package com.yishuailuo.mywebproject.jvm.reference;

import java.lang.ref.SoftReference;

public class SoftReferenceMainTest {
    
    public static void main(String[] args) {
        String str = "str";
        SoftReference<String> stringSoftReference = new SoftReference<>(str);
        String content = stringSoftReference.get();
        System.out.println(content);
        str = null;
        System.gc();
        System.out.println(stringSoftReference.get());
        System.gc();
        System.out.println(stringSoftReference.get());
    }
}
