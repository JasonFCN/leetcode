package com.cwj.leetcode;

public class ToHex405 {
    public static void main(String[] args) {
        // System.out.println(toHex(0b0111_1111_1110));
        System.out.println(toHex(-1));
    }

    public static String toHex(int num) {
        String[] arr = new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };
        StringBuilder hex = new StringBuilder("");
        boolean hightBit = false;
        for (int i = 1; i <= 8; i++) {
            int bitCount = (8 - i) * 4;
            int b = (num & (0b1111 << bitCount)) >>> bitCount;
            if (!hightBit && b != 0) {
                hightBit = true;
            }
            if (!hightBit) {
                if(i==8){
                    return "0";
                }
                continue;
            }
            hex.append(arr[b]);
        }
        return new String(hex);
    }
}