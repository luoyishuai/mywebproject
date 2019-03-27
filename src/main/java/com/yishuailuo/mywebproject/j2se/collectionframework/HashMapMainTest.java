package com.yishuailuo.mywebproject.j2se.collectionframework;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class HashMapMainTest {
    
    public static void main(String[] args) {
    
        HashMap<String, Integer> map = new HashMap<>(10);
        map.put("语文", 1);
        map.put("数学", 2);
        map.put("英语", 3);
        map.put("历史", 4);
        map.put("政治", 5);
        map.put("地理", 6);
        map.put("生物", 7);
        map.put("化学", 8);
    
        Set<Map.Entry<String, Integer>> set = map.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator = set.iterator();
        while(iterator.hasNext()) {
            Map.Entry entry = iterator.next();
            String key = (String) entry.getKey();
            Integer value = (Integer) entry.getValue();
            System.out.println("key:" + key + ",value:" + value);
        }
    
        System.out.println("---------------------------------------");
        
        HashMap<String, Integer> linkedHashMap = new LinkedHashMap<>(16, 0.75f, true);
        linkedHashMap.put("语文", 1);
        linkedHashMap.put("数学", 2);
        linkedHashMap.put("英语", 3);
        linkedHashMap.put("历史", 4);
        linkedHashMap.put("政治", 5);
        linkedHashMap.put("地理", 6);
        linkedHashMap.put("生物", 7);
        linkedHashMap.put("化学", 8);
    
        set = linkedHashMap.entrySet();
        iterator = set.iterator();
        while(iterator.hasNext()) {
            Map.Entry entry = iterator.next();
            String key = (String) entry.getKey();
            Integer value = (Integer) entry.getValue();
            System.out.println("key:" + key + ",value:" + value);
        }
    
        System.out.println("---------------------------------------");
        linkedHashMap.get("历史");
    
        set = linkedHashMap.entrySet();
        iterator = set.iterator();
        while(iterator.hasNext()) {
            Map.Entry entry = iterator.next();
            String key = (String) entry.getKey();
            Integer value = (Integer) entry.getValue();
            System.out.println("key:" + key + ",value:" + value);
        }
    }
}
