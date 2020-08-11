package com.cwj.leetcode;

public class CountPrimeSetBits762 {
    public static void main(String[] args) {
        System.out.println(countPrimeSetBits(6, 10));
    }

    public static int countPrimeSetBits(int L, int R){
        int count = 0;
        boolean[] arr = new boolean[20];
        arr[2] = true;
        arr[3] = true;
        arr[5] = true;
        arr[7] = true;
        arr[11] = true;
        arr[13] = true;
        arr[17] = true;
        arr[19] = true;
        for (int i = L; i <= R; i++) {
            if(arr[Integer.bitCount(i)]){
                count++;
            }
        }
        return count;
    }
}