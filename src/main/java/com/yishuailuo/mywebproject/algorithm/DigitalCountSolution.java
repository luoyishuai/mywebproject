package com.yishuailuo.mywebproject.algorithm;

public class DigitalCountSolution {

    public static void main(String[] args) {
        int count = digitCounts(1, 20);
        System.out.println(count);
    }

    /**
     * @param k: An integer
     * @param n: An integer
     * @return: An integer denote the count of digit k in 1..n
     */
    public static int digitCounts(int k, int n) {
        if (k <= 0 || k > 9) {
            return -1;
        }
        int digitCounts = 0;
        int ii;
        for (int i = k; i <= n; i++) {
            ii = i;
            while (ii != 0) {
                if (ii % 10 == k) {
                    digitCounts++;
                }
                ii /= 10;
            }
        }
        return digitCounts;
    }
}