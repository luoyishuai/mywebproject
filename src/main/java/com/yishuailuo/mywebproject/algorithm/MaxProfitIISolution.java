package com.yishuailuo.mywebproject.algorithm;

public class MaxProfitIISolution {

    public static void main(String[] args) {
        // https://www.programcreek.com/2014/02/leetcode-best-time-to-buy-and-sell-stock-ii-java/
        int[] prices = new int[]{5, 1, 1, 1, 1};
        System.out.println(maxProfit(prices));
    }

    private static int maxProfit(int[] arr) {
        int maxProfit = 0;
        int diff;
        for (int i = 1; i < arr.length; i++) {
            diff = arr[i] - arr[i - 1];
            if (diff > 0) {
                maxProfit += diff;
            }
        }
        return maxProfit;
    }
}
