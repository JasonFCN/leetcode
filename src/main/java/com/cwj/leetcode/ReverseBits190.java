package com.cwj.leetcode;


public class ReverseBits190 {
    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(0x33333333));
        System.out.println(Integer.toBinaryString(0x55555555));
        System.out.println(Integer.toBinaryString(0x0f0f0f0f));
        System.out.println(Integer.toBinaryString(0x3f));
        System.out.println(reverseBits(0b00000010100101000001111010011100));
        System.out.println(reverseBits2(0b00000010100101000001111010011100));
    }

    public static int reverseBits(int n) {
        for (int i = 0; i < 16; i++) {
            int a = 1 & (n >> i);
            int b = 1 & (n >> 32 - i - 1);
            if(a != b){
                if(a==1){
                    n |= (1 << 32 - i - 1);
                    n &= ~(1 << i);
                }else{
                    n &= ~(1 << 32 - i - 1);
                    n |= (1 << i);
                }
            }
        }
        return n;
    }

    public static int reverseBits2(int n) {
        n = (n >> 16) | (n << 16); 
        n = ((n & 0xff00ff00) >> 8) | ((n & 0x00ff00ff) << 8); 
        n = ((n & 0xf0f0f0f0) >> 4) | ((n & 0x0f0f0f0f) << 4); 
        n = ((n & 0xcccccccc) >> 2) | ((n & 0x33333333) << 2); 
        n = ((n & 0xaaaaaaaa) >> 1) | ((n & 0x55555555) << 1); 
        return n;
    }
}