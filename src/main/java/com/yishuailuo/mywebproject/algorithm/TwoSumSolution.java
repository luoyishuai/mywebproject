package com.yishuailuo.mywebproject.algorithm;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSumSolution {

    public static void main(String[] args) {
        int[] arr = new int[]{2, 11, 7, 7, 20, 3, 6};
        int[] resultIndexMap = twoSum(arr, 9);
        System.out.println(Arrays.toString(resultIndexMap));
    }


    private static int[] twoSum(int[] arr, final int target) {


        HashMap<Integer, Integer> resultIndexMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (!resultIndexMap.containsKey(arr[i])) {
                resultIndexMap.put(target - arr[i], i);
            } else {
                return new int[]{resultIndexMap.get(arr[i]), i};
            }
        }
        return new int[]{-1, -1};
    }
}
