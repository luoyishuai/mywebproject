package com.yishuailuo.mywebproject.algorithm.sorting.nlogn;

import java.util.Arrays;

public class QuickSort2 {

    public static void main(String[] args) {
        int[] sourceArr = {1, 3, 5, 6, 2, 4, 7, 9, 8, 101};
        int[] arr = Arrays.copyOf(sourceArr, sourceArr.length);
        int[] sortedArr = quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(sortedArr));
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
        int pivot = left;
        int index = pivot + 1;
        for (int i = index; i <= right; i++) {
            if (arr[i] < arr[pivot]) {
                swap(arr, i, index);
                index++;
            }
        }
        swap(arr, pivot, index - 1);
        return index - 1;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
