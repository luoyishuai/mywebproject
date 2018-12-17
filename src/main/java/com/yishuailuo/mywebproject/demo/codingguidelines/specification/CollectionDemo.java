package com.yishuailuo.mywebproject.demo.codingguidelines.specification;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class CollectionDemo {
    
    
    private static void testForeach() {
        
        List<String> list = new ArrayList<>();
        list.add("hello");
        list.add("world");
        list.add("!");
        Iterator<String> iterator = list.iterator();
        
        // while (iterator.hasNext()) {
        //     String item = iterator.next();
        //     if (Objects.equals("world", item)) {
        //         iterator.remove();
        //     }
        // }
        
        for (String item : list) {
            if (Objects.equals("hello", item)) {
                // list.remove(item);
                list.add("hhh");
            }
        }
    
        // for (String item : list) {
        //     System.out.println(item);
        // }
        
        // http://atbug.com/remove-element-while-looping-collection
        // http://rongmayisheng.com/?p=316
        
    }
    
    private static void testArraysAsList() {
        String[] strs = new String[]{"hello", "world"};
        List list = Arrays.asList(strs);
        list.add("something");
        strs[0] = "hi";
        System.out.println(list.get(0));
    }
    
    public static void main(String[] args) {
        // testArraysAsList();
        testForeach();
    }
    
    
}
