package com.yishuailuo.mywebproject.algorithm;

public class BinarySearchSolution {

    public static void main(String[] args) {
        int[] arr = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int index = binarySearch(arr, 8);
        System.out.println(index);
    }

    /**
     * 参考 java.util.Arrays 中 public static int BinarySearch 的实现
     *
     * @param arr
     * @param k
     * @return
     */
    private static int binarySearch(int[] arr, int k) {
        if (arr == null) {
            return -1;
        }
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int index = left + ((right - left) >> 1);
            if (arr[index] == k) {
                return index;
            } else if (arr[index] < k) {
                left = index + 1;
            } else {
                right = index - 1;
            }
        }
        return -1;
    }
}
