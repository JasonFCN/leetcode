package com.cwj.leetcode;

public class HammingDistance461 {
    public static void main(String[] args) {
        System.out.println(hammingDistance(1, 4));
    }

    public static int hammingDistance(int x, int y){
        int z = x ^ y;
        int count = 0;
        while(z != 0){
            z &=(z-1);
            count++;
        }
        return count;
    }
}