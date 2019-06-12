package com.yishuailuo.mywebproject.algorithm;

import java.util.Arrays;

public class AllPermutationSolution {

    private static int total = 0;

    public static void main(String[] args) {
        int[] str = {0, 1, 2, 2, 3};
        fullArray(str, 0, str.length - 1);
        System.out.println(total);
    }

    private static void fullArray(int[] array, int cursor, int end) {
        if (cursor == end) {
            System.out.println(Arrays.toString(array));
            total++;
        } else {
            for (int i = cursor; i <= end; i++) {
                if (!swapAccepted(array, cursor, i)) {
                    continue;
                }
                swap(array, cursor, i);
                fullArray(array, cursor + 1, end);
                swap(array, cursor, i); // 用于对之前交换过的数据进行还原
            }
        }
    }

    static boolean swapAccepted(int[] array, int start, int end) {
        for (int i = start; i < end; i++) {
            if (array[i] == array[end]) {
                return false;
            }
        }
        return true;
    }

    static void swap(int[] str, int i, int j) {
        int temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    }
}
