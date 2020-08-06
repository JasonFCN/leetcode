package com.cwj.leetcode;

public class IsPowerOfFour342 {

    public static void main(String[] args) {
        System.out.println(isPowerOfFour(16));
        System.out.println(16 & (0xaaaaaaaa));
    }

    public static boolean isPowerOfFour(int num) {
        return (num > 0) && ((num & (num - 1)) == 0) && ((num & 0xaaaaaaaa) == 0);
    }
}