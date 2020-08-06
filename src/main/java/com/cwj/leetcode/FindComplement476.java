package com.cwj.leetcode;

public class FindComplement476 {
    public static void main(String[] args) {
        System.out.println(findComplement(5));
    }

    public static int findComplement(int num){
        int m = num;
        num |= num >> 1;
        num |= num >> 2;
        num |= num >> 4;
        num |= num >> 8;
        num |= num >> 16;
        return m ^ num;
    }
}