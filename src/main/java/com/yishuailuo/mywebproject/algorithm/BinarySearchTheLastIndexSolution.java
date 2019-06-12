package com.yishuailuo.mywebproject.algorithm;

public class BinarySearchTheLastIndexSolution {

    public static void main(String[] args) {
        int[] arr = new int[]{0, 1, 2, 2, 4, 4, 5, 5, 5, 5, 100, 100, 101};
        int index = binarySearchTheLastIndex(arr, 5);
        System.out.println(index);
    }

    private static int binarySearchTheLastIndex(int[] arr, int k) {
        if (arr == null) {
            return -1;
        }
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int index = left + ((right - left) >> 1);
            if (arr[index] == k) {
                int i = index - 1;
                for (; i <= right; i--) {
                    if (arr[i] != k) {
                        break;
                    }
                }
                return i + 1;
            } else if (arr[index] < k) {
                left = index + 1;
            } else {
                right = index - 1;
            }
        }
        return -1;
    }
}
