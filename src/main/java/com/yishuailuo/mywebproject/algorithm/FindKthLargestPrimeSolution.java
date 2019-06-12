package com.yishuailuo.mywebproject.algorithm;

import java.util.Arrays;

public class FindKthLargestPrimeSolution {

    public static void main(String[] args) {
        // prime list: 2, 3, 5, 7, 11
        int[] sourceArr = new int[]{9, 7, 4, 3, 5, 6, 2, 8, 1, 10, 11};
        int[] arr = Arrays.copyOf(sourceArr, sourceArr.length);
        int[] sortedArr = quickSort(arr, 0, arr.length - 1);
        int kthLargestPrime = findKthLargestPrime(sortedArr, 0);
        System.out.println(kthLargestPrime);
    }

    private static int findKthLargestPrime(int[] arr, int k) {
        if (arr == null || k <= 0 || arr.length < k) {
            return -1;
        }
        int primeCount = 0;
        for (int i = arr.length - 1; i > 0; i--) {
            if (isPrime(arr[i])) {
                primeCount++;
                if (primeCount == k) {
                    return arr[i];
                }
            }
        }
        return -1;
    }

    private static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
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

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
