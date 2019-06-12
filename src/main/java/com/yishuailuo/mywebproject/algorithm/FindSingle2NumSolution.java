package com.yishuailuo.mywebproject.algorithm;

import java.util.Arrays;

public class FindSingle2NumSolution {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 2, 1, 3, 4, 5, 3};
        int[] single2Num = findSingle2Num(arr);
        System.out.println(Arrays.toString(single2Num));
    }

    // http://www.voidcn.com/article/p-tfgblomt-brp.html
    private static int[] findSingle2Num(int[] arr) {
        if (arr == null || arr.length <= 1 || arr.length % 2 == 1) {
            return null;
        }
        if (arr.length == 2) {
            return Arrays.copyOf(arr, arr.length);
        }
        int xor = 0;
        for (int n : arr) {
            xor ^= n;
        }
        int bitIndex = findFirstBit1(xor);
        int n1 = 0;
        int n2 = 0;
        for (int n : arr) {
            if (is1OfBitIndex(n, bitIndex)) {
                n1 ^= n;
            } else {
                n2 ^= n;
            }
        }
        return new int[]{n1, n2};
    }

    private static boolean is1OfBitIndex(int n, int index) {
        n = n >> index;
        return (n & 1) == 0;
    }

    private static int findFirstBit1(int n) {
        int bitIndex = 0;
        while ((n & 1) == 0) {
            n = n >> 1;
            bitIndex++;
        }
        return bitIndex;
    }
}
