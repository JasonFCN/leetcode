package com.cwj.leetcode;

public class RangeBitwiseAnd201 {
    public static void main(String[] args) {
        System.out.println(rangeBitwiseAnd(4, 5));
        System.out.println(rangeBitwiseAnd2(4, 5));
    }

    public static int rangeBitwiseAnd(int m, int n) {
        if(m==n){
            return m;
        }
        int a = (n - m);
        a |= a >> 1;
        a |= a >> 2;
        a |= a >> 4;
        a |= a >> 8;
        a |= a >> 16;
        return m & n & ~a;
    }

    public static int rangeBitwiseAnd2(int m, int n) {
        int result = 0;
        for (int i = m; i < n; i++) {
            result = m & (m+1);
        }
        return result;
    }
}