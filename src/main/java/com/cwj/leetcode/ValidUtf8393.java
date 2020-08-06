package com.cwj.leetcode;

public class ValidUtf8393 {
    public static void main(String[] args) {
        int[] data = new int[] { 197, 130, 1 };
        System.out.println(validUtf8(data));
        ;
    }

    public static boolean validUtf8(int[] data) {
        for (int i = 0; i < data.length; i++) {
            int n = data[i];
            if (n >> 7 == 0) {
                // 单字节
            } else if (n >> 7 == 1) {
                if (n >> 5 == 0b110) {
                    // 双字节
                    if (i + 1 >= data.length) {
                        return false;
                    }
                    int n2 = data[++i];
                    if (n2 >> 6 != 0b10) {
                        return false;
                    }
                } else if (n >> 4 == 0b1110) {
                    // 三字节
                    if (i + 2 >= data.length) {
                        return false;
                    }
                    int n2 = data[++i];
                    int n3 = data[++i];
                    if ((n2 >> 6 != 0b10) || (n3 >> 6 != 0b10)) {
                        return false;
                    }
                } else if (n >> 3 == 0b11110) {
                    // 四字节
                    if (i + 3 >= data.length) {
                        return false;
                    }
                    int n2 = data[++i];
                    int n3 = data[++i];
                    int n4 = data[++i];
                    if ((n2 >> 6 != 0b10) || (n3 >> 6 != 0b10) || (n4 >> 6 != 0b10)) {
                        return false;
                    }
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }
}