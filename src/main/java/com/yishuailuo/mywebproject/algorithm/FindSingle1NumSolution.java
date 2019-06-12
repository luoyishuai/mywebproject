package com.yishuailuo.mywebproject.algorithm;

public class FindSingle1NumSolution {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 2, 2, 3, 4, 4, 5, 5};
        int result = findSingle1Num(arr);
        System.out.println(result);
    }

    private static int findSingle1Num(int[] arr) {
        int result = 0;
        for (int i : arr) {
            result ^= i;
        }
        return result;
    }
}
