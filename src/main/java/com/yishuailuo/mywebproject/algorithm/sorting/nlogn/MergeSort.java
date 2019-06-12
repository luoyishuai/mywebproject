package com.yishuailuo.mywebproject.algorithm.sorting.nlogn;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] sourceArr = new int[]{12, 11, 13, 9, 6, 7};
        int[] arr = Arrays.copyOf(sourceArr, sourceArr.length);
        sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[] arr, int left, int right) {
        if (left < right) {
            int middle = (left + right) >>> 1;
            sort(arr, left, middle);
            sort(arr, middle + 1, right);
            merge(arr, left, middle, right);
        }
    }

    private static void merge(int[] arr, int left, int middle, int right) {
        int leftLength = middle - left + 1;
        int rightLength = right - middle;
        int[] leftArr = new int[leftLength];
        int[] rightArr = new int[leftLength];
        for (int i = 0; i < leftLength; i++) {
            leftArr[i] = arr[left + i];
        }
        for (int j = 0; j < rightLength; j++) {
            rightArr[j] = arr[middle + 1 + j];
        }

        int i = 0;
        int j = 0;
        int k = left;
        while (i < leftLength && j < rightLength) {
            if (leftArr[i] < rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }

        while (i < leftLength) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }

        while (j < rightLength) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }
    }
}
