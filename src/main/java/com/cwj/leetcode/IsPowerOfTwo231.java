package com.cwj.leetcode;

public class IsPowerOfTwo231 {
    public static void main(String[] args) {
        System.out.println(isPowerOfTwo2(0b101010));
    }

    public static boolean isPowerOfTwo(int n) {
        return (n ^ (n - 1)) == ((n - 1) << 1) + 1;
    }
    public static boolean isPowerOfTwo2(int n) {
        if (n == 0) return false;
        long x = (long) n;
        return (x & (x - 1)) == 0;
    }
}