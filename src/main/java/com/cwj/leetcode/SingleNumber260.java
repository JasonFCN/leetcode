package com.cwj.leetcode;

public class SingleNumber260 {
    public static void main(String[] args) {
        int[] arr = singleNumber(new int[] { 1, 2, 1, 3, 2, 5 });
        System.out.println(arr[0]);
        System.out.println(arr[1]);
    }

    public static int[] singleNumber(int[] nums) {
        int bitmask = 0;
        for (int i = 0; i < nums.length; i++) {
            bitmask ^= nums[i];
        }
        int diffBit = bitmask & (-bitmask);

        int x = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((diffBit & nums[i]) != 0) {
                x ^= nums[i];
            }
        }
        return new int[] { x, bitmask ^ x };
    }

}