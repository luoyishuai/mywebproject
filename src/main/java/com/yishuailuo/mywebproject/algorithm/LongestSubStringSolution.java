package com.yishuailuo.mywebproject.algorithm;

import java.util.HashMap;
import java.util.Map;

public class LongestSubStringSolution {

    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int maxLength = 0;
        int now = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i)))    {
                now = Math.max(map.get(s.charAt(i)) + 1, now);
                if ((i - now + 1) > maxLength) {
                    maxLength = i - now + 1;
                }
            } else {
                if ((i - now + 1) > maxLength) {
                    maxLength = i - now + 1;
                }
            }
            map.put(s.charAt(i), i);
        }
        return maxLength;
    }

}


