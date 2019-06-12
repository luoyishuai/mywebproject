package com.yishuailuo.mywebproject.algorithm;

import java.util.Arrays;

public class FindKthLargestSolution {

    public static void main(String[] args) {
        int[] sourceArray = new int[]{3, 5, 8, 1, 2, 9, 4, 7, 6};
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
        int[] sortedArray = quickSort(arr, 0, arr.length - 1);
        System.out.println(findKthLargest(sortedArray, 4));
    }

    private static int findKthLargest(int[] arr, int k) {
        if (arr == null || k < 1) {
            return 0;
        }
        return arr[arr.length - k];
    }

    private static int[] quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int partitionIndex = partition(arr, left, right);
            quickSort(arr, left, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, right);
        }
        return arr;
    }

    private static int partition(int[] arr, int left, int right) {
        int pivot = left; // 基准数下标
        int index = pivot + 1; // 分区下标的下一位
        for (int i = index; i <= right; i++) {
            if (arr[i] < arr[pivot]) {
                // 所有比基准小的数都排在分区下标的左边，通过交换实现
                swap(arr, i, index);
                index++;
            }
        }
        swap(arr, pivot, index - 1); // 遍历一轮后，把基准值移动到分区下标处，并返回分区下标
        return index - 1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
