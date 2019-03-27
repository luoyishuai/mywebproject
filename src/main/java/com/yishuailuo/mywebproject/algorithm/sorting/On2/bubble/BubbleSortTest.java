package com.yishuailuo.mywebproject.algorithm.sorting.On2.bubble;

import java.util.Arrays;

public class BubbleSortTest {
    
    public static void main(String[] args) {
        int[] unsortedArray = new int[]{2, 3, 1, 8, 9, 5, 6, 4, 7, 0};
        System.out.println("Before sorting: " + Arrays.toString(unsortedArray));
        int[] sortedArray = bubbleSort(unsortedArray);
        System.out.println("After sorting: " + Arrays.toString(sortedArray));
    }
    
    public static int[] bubbleSort(int[] array) {
        int arrayLength = array.length;
        int[] sortedArray = Arrays.copyOf(array, arrayLength);
        boolean noswap = true;
        for (int i = 1; i < arrayLength; i++) {
            for (int j = 0; j < arrayLength - i; j++) {
                if (sortedArray[j] > sortedArray[j + 1]) {
                    swqp(sortedArray, j, j + 1);
                    noswap = false;
                }
            }
            if (noswap) {
                break;
            }
        }
        return sortedArray;
    }
    
    private static void swqp(int[] array, int i, int j) {
        int temp = array[j];
        array[j] = array[i];
        array[i] = temp;
    }
    
}
