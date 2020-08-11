package com.cwj.leetcode;

import java.util.Arrays;

public class SortByBits1356 {
    public static void main(String[] args) {
        int[] result = sortByBits(new int[]{0,1,2,3,4,5,6,7,8});
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    public static int[] sortByBits(int[] arr){
        int[] nums = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            nums[i] = Integer.bitCount(arr[i]) * 10000000 + arr[i];
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] % 10000000;
        }
        return nums;
    }
}