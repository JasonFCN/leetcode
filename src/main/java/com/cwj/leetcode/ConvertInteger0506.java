package com.cwj.leetcode;

public class ConvertInteger0506 {
    public static void main(String[] args) {
        
    }

    public static int convertInteger(int A, int B){
        return Integer.bitCount(A ^ B);
    }
}