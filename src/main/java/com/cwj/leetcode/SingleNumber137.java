package com.cwj.leetcode;

public class SingleNumber137 {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,1,2,3,1,2,3,4};
        System.out.println(singleNumber(nums));
    }

    public static int singleNumber(int[] nums) {
        int seen_once = 0, seen_twice = 0;

        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            seen_once = ~seen_twice & (seen_once ^ x);
            seen_twice = ~seen_once & (seen_twice ^ x);
        }
        return seen_once;
    }
}