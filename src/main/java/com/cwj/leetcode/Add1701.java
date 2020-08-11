package com.cwj.leetcode;

public class Add1701 {
    public static void main(String[] args) {
        System.out.println(add(1, 8));
    }

    public static int add(int a, int b) {
        while (b != 0) {
            int c = a ^ b;
            b = (a & b) << 1;
            a = c;
        }
        return a;
    }
}