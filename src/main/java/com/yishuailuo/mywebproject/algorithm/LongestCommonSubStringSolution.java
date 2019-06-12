//package com.yishuailuo.mywebproject.algorithm;
//
//public class LongestCommonSubStringSolution {
//
//    public static void main(String[] args) {
//        String[] strs = {"aaa", "baa"};
//        System.out.println(findLongestCommonPrefix(strs));
//    }
//
//    private static String findLongestCommonSubString() {
//
//    }
//
//    int KMP(String[] t, String[] p) {
//        int i = 0;
//        int j = 0;
//        while (i < t.length && j < p.length) {
//            if (j == -1 || t[i] == p[j]) {
//                i++;
//                j++;
//            } else
//                j = next[j];
//        }
//
//        if (j == p.length)
//            return i - j;
//        else
//            return -1;
//    }
//
//}
//
