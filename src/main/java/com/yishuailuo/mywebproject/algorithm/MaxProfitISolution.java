package com.yishuailuo.mywebproject.algorithm;

public class MaxProfitISolution {

    public static void main(String[] args) {
        // https://www.programcreek.com/2014/02/leetcode-best-time-to-buy-and-sell-stock-java/
        int[] prices = new int[]{3, 2, 3, 1, 9};
        System.out.println(maxProfit(prices));
    }

    private static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int minSoFar = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            maxProfit = Math.max(maxProfit, prices[i] - minSoFar);
            minSoFar = Math.min(minSoFar, prices[i]);
        }
        return maxProfit;
    }
}
