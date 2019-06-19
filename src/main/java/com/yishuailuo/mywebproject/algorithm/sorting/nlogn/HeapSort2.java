package com.yishuailuo.mywebproject.algorithm.sorting.nlogn;

import java.util.Arrays;

public class HeapSort2 {

    public static void main(String[] args) {
        int[] sourceArr = new int[]{4, 1, 3, 2, 16, 9, 10, 14, 8, 7};
        int[] arr = Arrays.copyOf(sourceArr, sourceArr.length);
        int[] sortedArr = heapSort(arr);
        System.out.println(Arrays.toString(sortedArr));
    }

    private static int[] heapSort(int[] arr) {
        buildHeap(arr);
        int[] sortedArr = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            sortedArr[i] = arr[0];
            if (i == 0) {
                break;
            }
            swap(arr, 0, i);
            heapify(arr, 0, i);
        }
        return sortedArr;
    }

    private static void buildHeap(int[] arr) {
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            heapify(arr, i, arr.length);
        }
    }

    private static void heapify(int[] arr, int i, int len) {
        int leftIndex = 2 * i + 1;
        int rightIndex = 2 * i + 2;
        int largestIndex = i;

        if (leftIndex < len && arr[leftIndex] > arr[largestIndex]) {
            largestIndex = leftIndex;
        }

        if (rightIndex < len && arr[rightIndex] > arr[largestIndex]) {
            largestIndex = rightIndex;
        }

        if (largestIndex != i) {
            swap(arr, largestIndex, i);
            heapify(arr, largestIndex, len);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
