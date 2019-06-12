package com.yishuailuo.mywebproject.algorithm;

public class MaxProfitIIISolution {


    public static void main(String[] args) {
        // https://www.programcreek.com/2014/02/leetcode-best-time-to-buy-and-sell-stock-iii-java/
        int[] prices = new int[]{1, 4, 5, 7, 6, 3, 2, 9};
        System.out.println(maxProfit(prices));
    }

    private static int maxProfit(int[] prices) {

        if (prices == null || prices.length < 2) {
            return 0;
        }

        int[] leftMaxProfit = new int[prices.length];
        int[] rightMaxProfit = new int[prices.length];

        leftMaxProfit[0] = 0;
        int minSoFar = prices[0];
        for (int i = 1; i < prices.length; i++) {
            minSoFar = Math.min(minSoFar, prices[i]);
            leftMaxProfit[i] = Math.max(leftMaxProfit[i - 1], prices[i] - minSoFar);
        }

        rightMaxProfit[prices.length - 1] = 0;
        int maxSoFor = prices[prices.length - 1];
        for (int i = prices.length - 2; i >= 0; i--) {
            maxSoFor = Math.max(maxSoFor, prices[i]);
            rightMaxProfit[i] = Math.max(rightMaxProfit[i + 1], maxSoFor - prices[i]);
        }

        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            maxProfit = Math.max(maxProfit, leftMaxProfit[i] + rightMaxProfit[i]);
        }
        return maxProfit;
    }
}
