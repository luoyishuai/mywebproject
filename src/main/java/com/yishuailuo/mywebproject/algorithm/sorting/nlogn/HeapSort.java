package com.yishuailuo.mywebproject.algorithm.sorting.nlogn;

public class HeapSort {

    public static void main(String[] args) {
        int[] arr = new int[]{4, 1, 3, 2, 16, 9, 10, 14, 8, 7};
        heapSort(arr);
    }

    private static int[] heapSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return arr;
        }
        buildHeap(arr);
        for (int i = arr.length - 1; i >= 1; i--) {
            System.out.print(arr[0]);
            swap(arr, 0, i);
            heapify(arr, 0, i);
        }
        System.out.println(arr[0]);
        return arr;
    }

    private static void buildHeap(int[] array) {
        int n = array.length;// 数组中元素的个数
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(array, i, n);
    }

    private static void heapify(int[] arr, int i, int len) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int largest = i;

        if (left < len && arr[left] > arr[largest]) {
            largest = left;
        }

        if (right < len && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != i) {
            swap(arr, i, largest);
            heapify(arr, largest, len);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
