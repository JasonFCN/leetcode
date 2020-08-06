package com.cwj.leetcode;

public class GetSum371 {
    public static void main(String[] args) {
        System.out.println(getSum(1, 4));
    }

    public static int getSum(int a, int b) {
        // 模拟计算机的加法器原理
        // 1，异或运算的结果为不考虑进位的情况下两数之和
        // 2，与运算 + 左移1位 等于两数之和的进位结果
        // 当2步骤的结果为0时，两数之和就等于1步骤的结果
        while (b != 0) {
            int temp = a ^ b;
            b = a & b << 1;
            a = temp;
        }
        return a;
    }
}