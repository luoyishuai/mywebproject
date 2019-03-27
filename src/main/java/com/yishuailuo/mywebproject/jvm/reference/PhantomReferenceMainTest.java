package com.yishuailuo.mywebproject.jvm.reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

public class PhantomReferenceMainTest {
    
    public static void main(String[] args) {
        String str = "str";
        ReferenceQueue referenceQueue = new ReferenceQueue();
        PhantomReference<String> phantomReference = new PhantomReference<>(str, referenceQueue);
        String content = phantomReference.get();
        System.out.println(content);
        System.gc();
        System.out.println(phantomReference.get());
    }
}
