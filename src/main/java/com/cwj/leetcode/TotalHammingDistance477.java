package com.cwj.leetcode;

public class TotalHammingDistance477 {
    public static void main(String[] args) {
        // 求各个位上：（1的个数 * 0的个数）的总和
        // length*(n0 + n1 +...) - (n0^2 + n1^2 +...)
        // n0,n1.. 为所有数的第m位1的个数。
        System.out.println(totalHammingDistance(new int[]{4,14,2}));
    }

    public static int totalHammingDistance(int[] nums){
        int count = 0;
        int[] sums = new int[31];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < 31; j++) {
                sums[j] += nums[i] & 1;
                nums[i] >>= 1;
            }
        }

        for (int i = 0; i < sums.length; i++) {
            count += sums[i] * (nums.length - sums[i]);
        }
        return count;
    }
}