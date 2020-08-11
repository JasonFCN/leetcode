package com.cwj.leetcode;

public class ReverseBits0503 {
    public static void main(String[] args) {
        // BitSet bitSet = BitSet.valueOf(new long[]{1775});
        // System.out.println(bitSet);
        // int index = 0;
        // while(bitSet.nextClearBit(index)!=-1){
        //     System.out.println(bitSet.nextClearBit(index));
        //     index = bitSet.nextClearBit(index) + 1;
        // }
        reverseBits(0b100101011101110111);
    }

    public static int reverseBits(int num){
        int maxLen = 0, preLen = 0, curLen = 0, bits = 32;
        while (bits-- > 0) {
            if ((num & 1) == 0) {
                curLen -= preLen;
                preLen = curLen + 1;
            }
            curLen++;
            maxLen = Math.max(maxLen, curLen);
            num >>= 1;
        }
        return maxLen;
    }
}