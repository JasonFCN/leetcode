package com.cwj.leetcode;

public class MajorityElement169 {

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,23,2};
        int n = majorityElement(nums);
        System.out.println(n);
    }

    public static int majorityElement(int[] nums) {
        // 投票算法
        int count = 0;
        int target = 0;
        for (int i = 0; i < nums.length; i++) {
            if(count==0){
                target = nums[i];
            }
            count += target==nums[i] ? 1 : -1;
        }
        return target;
    }
}