package com.yishuailuo.mywebproject.algorithm;

import java.util.PriorityQueue;

public class MediaSolution {

    public static void main(String[] args) {
        int[] arr = new int[]{4, 2, 1, 3, 10, 11, 12, 13};
        double media = media(arr);
        assert media == 7;

        int[] arr1 = new int[]{4, 2, 1, 3, 5, 6};
        double media1 = media(arr1);
        assert media1 == 3.5;
        System.out.println("finish.");
    }

    private static double media(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int size = (arr.length + 1) / 2;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(size);
        for (int i = 0; i < size; i++) {
            priorityQueue.add(arr[i]);
        }
        for (int i = size; i < arr.length; i++) {
            Integer peek = priorityQueue.peek();
            if (peek != null && arr[i] < peek) {
                priorityQueue.add(arr[i]);
            }
        }

        if (arr.length % 2 == 1) {
            return priorityQueue.peek();
        } else {
            return (priorityQueue.poll() + priorityQueue.peek()) / 2.0;
        }
    }

}
