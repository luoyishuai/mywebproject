package com.yishuailuo.mywebproject.algorithm.sorting.On2.insertion;

import java.util.Arrays;

public class InsertionSortTest {
    
    public static void main(String[] args) {
        int[] unsortedArray = new int[]{2, 3, 1, 8, 9, 5, 6, 4, 7, 0};
        System.out.println("Before sorting: " + Arrays.toString(unsortedArray));
        int[] sortedArray = insertionSort(unsortedArray);
        System.out.println("After sorting: " + Arrays.toString(sortedArray));
    }
    
    public static int[] insertionSort(int[] array) {
        int arrayLength = array.length;
        int[] sortedArray = Arrays.copyOf(array, arrayLength);
        int current;
        for (int i = 1; i < arrayLength; i++) {
            current = sortedArray[i];
            int insertIndex = i;
            while (insertIndex > 0 && current < sortedArray[insertIndex - 1]) {
                sortedArray[insertIndex] = sortedArray[insertIndex - 1];
                insertIndex--;
            }
            if (insertIndex != i) {
                sortedArray[insertIndex] = current;
            }
        }
        return sortedArray;
    }
    
}
