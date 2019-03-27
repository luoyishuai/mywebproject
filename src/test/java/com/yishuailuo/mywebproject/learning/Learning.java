package com.yishuailuo.mywebproject.learning;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Learning {
    
    @Test
    public void test0() throws Exception {
        ArrayList<String> list = new ArrayList<>(2);
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        list.add("f");
        list.add("h");
        
        list.remove("a");
        list.remove("d");
        
    }
    
    @Test
    public void test1() throws Exception {
        LinkedList<String> list = new LinkedList();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        list.add("f");
        list.add("h");
        
        list.remove("a");
        list.remove("d");
        
    }
}
