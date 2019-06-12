package com.yishuailuo.mywebproject.algorithm.sorting.On2.selection;

import java.util.Arrays;

public class SelectionSortTest {
    
    public static void main(String[] args) {
        int[] unsortedArray = new int[]{2, 3, 1, 8, 9, 5, 6, 4, 7, 0};
        System.out.println("Before sorting: " + Arrays.toString(unsortedArray));
        int[] sortedArray = selectionSort(unsortedArray);
        System.out.println("After sorting: " + Arrays.toString(sortedArray));
    }
    
    private static int[] selectionSort(int[] array) {
        int arrayLength = array.length;
        int[] sortedArray = Arrays.copyOf(array, arrayLength);
        int min;
        for (int i = 0; i < arrayLength - 1; i++) {
            min = i;
            for (int j = i + 1; j < arrayLength; j++) {
                if (sortedArray[j] < sortedArray[min]) {
                    min = j;
                }
            }
            if (i != min) {
                swqp(sortedArray, i, min);
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
