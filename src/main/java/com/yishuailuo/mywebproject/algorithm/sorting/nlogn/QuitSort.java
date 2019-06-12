package com.yishuailuo.mywebproject.algorithm.sorting.nlogn;

import java.util.Arrays;

public class QuitSort {

    public static void main(String[] args) {

        int[] sourceArray = new int[]{3, 5, 8, 1, 2, 9, 4, 7, 6};
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
        int[] sortedArray = quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(sortedArray));
    }

    /**
     * 参考 java.util.Arrays 中的实现 DualPivotSort 双基准快排实现和归并排序，俄罗斯 https://www.jianshu.com/p/2c6f79e8ce6e
     *
     * @param arr
     * @param left
     * @param right
     * @return
     */
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

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
