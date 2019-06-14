package com.yishuailuo.mywebproject.algorithm;

public class FindMajoritySolution {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 2, 1, 1, 2, 2, 2, 2, 4, 5};
        int majority = findMajority(arr);
        System.out.println(majority);
    }


    public static int findMajority(int[] arr) {
        int result = 0;
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == result) {
                count++;
            } else {
                if (count == 0) {
                    result = arr[i];
                } else {
                    count--;
                }
            }
        }
        return result;
    }
}
