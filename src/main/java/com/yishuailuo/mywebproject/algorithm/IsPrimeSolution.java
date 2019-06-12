package com.yishuailuo.mywebproject.algorithm;

public class IsPrimeSolution {

    public static void main(String[] args) {
        int n = 23;
        boolean isPrime = isPrime(n);
        System.out.println(isPrime);
    }

    private static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
