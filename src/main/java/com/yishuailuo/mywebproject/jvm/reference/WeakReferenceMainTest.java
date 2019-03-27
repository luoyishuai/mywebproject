package com.yishuailuo.mywebproject.jvm.reference;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;

public class WeakReferenceMainTest {
    public static void main(String[] args) throws InterruptedException {
        String str = "str";
        WeakReference<String> stringWeakReference = new WeakReference<>(str);
        String content = stringWeakReference.get();
        System.out.println(content);
        str = null;
        System.gc();
        TimeUnit.MINUTES.sleep(1);
        System.out.println(stringWeakReference.get());
        System.gc();
        System.out.println(stringWeakReference.get());
    }
}
