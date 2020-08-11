package com.cwj.leetcode;

public class XorOperation1486 {
    public static void main(String[] args) {
        System.out.println(xorOperation(10, 5));
    }

    public static int xorOperation(int n, int start) {
        int ans = 0;
        if (((start >> 1) & 1) == 1) {
            ans = ((start >> 1) - 1) ^ xor(n + 1, (start >> 1) - 1);
        } else {
            ans = xor(n, start >> 1);
        }

        if ((n & start & 1) == 1) {
            return (ans << 1) + 1;
        } else {
            return ans << 1;
        }
    }

    public static int xor(int n, int start) {
        if ((n & 1) == 1) {
            return (n >> 1) & 1 ^ (start + n - 1);
        } else {
            return (n >> 1) & 1;
        }
    }
}