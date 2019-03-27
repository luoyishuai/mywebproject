package com.yishuailuo.mywebproject.j2se.collectionframework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;

public class IteratorRemoveMainTest {
    
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>(Arrays.asList("a", "b", "c", "d"));
        Iterator<String> iter = list.iterator();
        while (iter.hasNext()) {
            String s = iter.next();
            if (s.equals("a")) {
                // list.remove(0);
                iter.remove();
            }
        }
        System.out.println(list);
    }
    
}
