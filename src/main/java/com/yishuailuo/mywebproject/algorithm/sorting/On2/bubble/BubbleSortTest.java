package com.yishuailuo.mywebproject.algorithm.sorting.On2.bubble;

import java.util.Arrays;

public class BubbleSortTest {

    public static void main(String[] args) {
        int[] unsortedArray = new int[]{2, 3, 1, 8, 9, 5, 6, 4, 7, 0};
        System.out.println("Before sorting: " + Arrays.toString(unsortedArray));
        int[] sortedArray = bubbleSort(unsortedArray);
        System.out.println("After sorting: " + Arrays.toString(sortedArray));
    }

    private static int[] bubbleSort(int[] array) {
        int arrayLength = array.length;
        int[] sortedArray = Arrays.copyOf(array, arrayLength);
        boolean noswap = true;
        for (int i = 1; i < arrayLength; i++) {
            // 只需循环 1 到 arrayLength 轮
            for (int j = 0; j < arrayLength - i; j++) {
                // 因为每一轮都已筛选出最小的值，所以每一轮也只需要到 arrayLength - i
                if (sortedArray[j] > sortedArray[j + 1]) {
                    swap(sortedArray, j, j + 1);
                    noswap = false;
                }
            }
            if (noswap) {
                break;
            }
        }
        return sortedArray;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[j];
        array[j] = array[i];
        array[i] = temp;
    }

}
