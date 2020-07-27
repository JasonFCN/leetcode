package com.cwj.leetcode;

import java.util.BitSet;

public class MissingNumber268 {
    public static void main(String[] args) {
        System.out.println(missingNumber2(new int[]{45,35,38,13,12,23,48,15,44,21,43,26,6,37,1,19,22,3,11,32,4,16,28,49,29,36,33,8,9,39,46,17,41,7,2,5,27,20,40,34,30,25,47,0,31,42,24,10,14}));
    }
    
    public static int missingNumber(int[] nums) {
        BitSet bitSet = new BitSet();
        BitSet bitSet2 = new BitSet();
        for (int i = 0; i < nums.length; i++) {
            bitSet.set(nums[i]);
            bitSet2.set(i);
        }
        bitSet2.set(nums.length);
        bitSet.xor(bitSet2);
        return bitSet.nextSetBit(0);
    }
    public static int missingNumber2(int[] nums) {
        int missing = nums.length;
        for (int i = 0; i < nums.length; i++) {
            missing ^= i ^ nums[i];
        }
        return missing;
    }
}