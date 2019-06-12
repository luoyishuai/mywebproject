package com.yishuailuo.mywebproject.algorithm;

import java.util.Arrays;
import java.util.Objects;

public class LongestCommonPrefixSolution {

    public static void main(String[] args) {
        String[] strs = {"aaa", "baa", "baa"};
        System.out.println(findLongestCommonPrefix(strs));
    }

    private static String findLongestCommonPrefix(String[] strs) {
        if (!checkStrs(strs)) {
            return "";
        }
        StringBuilder resultStringBuilder = new StringBuilder();
        Arrays.sort(strs);
        int minLength = Math.min(strs[0].length(), strs[strs.length - 1].length());
        for (int i = 0; i < minLength; i++) {
            if (Objects.equals(strs[0].charAt(i), strs[strs.length - 1].charAt(i))) {
                resultStringBuilder.append(strs[0].charAt(i));
            } else {
                break;
            }
        }
        return resultStringBuilder.toString();
    }

    private static boolean checkStrs(String[] strs) {
        if (strs != null) {
            for (String str : strs) {
                if (str == null || str.length() == 0) {
                    return false;
                }
            }
        }
        return true;
    }
}

