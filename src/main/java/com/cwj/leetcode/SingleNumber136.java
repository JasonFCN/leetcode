package com.cwj.leetcode;

import java.util.BitSet;

public class SingleNumber136 {
    public static void main(String[] args) {
        
    }

    public static int singleNumber(int[] nums) {
        BitSet bitSet = new BitSet();
        BitSet bitSet2 = new BitSet();
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            if(n<0){
                bitSet2.set(-nums[i], !bitSet2.get(-nums[i]));
            }else{
                bitSet.set(nums[i], !bitSet.get(nums[i]));
            }
        }

        return bitSet.cardinality()>0 ? bitSet.nextSetBit(0) : -bitSet2.nextSetBit(0);
    }
}