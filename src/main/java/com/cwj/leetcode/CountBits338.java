package com.cwj.leetcode;

public class CountBits338 {
    public static void main(String[] args) {
        
    }

    public static int[] countBits(int num) {
        int[] ans = new int[num + 1];
        for (int i = 1; i <= num; ++i)
            ans[i] = ans[i & (i - 1)] + 1;
        return ans;
    }
}