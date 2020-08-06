package com.cwj.leetcode;

/**
 * 
 * 给定一个正整数 n，你可以做如下操作： 1. 如果 n 是偶数，则用 n / 2替换 n。 2. 如果 n 是奇数，则可以用 n + 1或n -
 * 1替换 n。 n 变为 1 所需的最小替换次数是多少？
 */
public class IntegerReplacement397 {
    public static void main(String[] args) {
        int i = integerReplacement(0b10001101001111011010);
        System.out.println(i);
    }

    public static int integerReplacement(int n) {
        int count = 0;
        long m = (long)n;
        while (m != 1) {
            if ((m & 1) == 0) {
                m >>= 1;
            }else{
                if(m==3){
                    // m 等于3时，-1
                    m = 2;
                }else{
                    if((m & 3) == 3){
                        // 如果末两位 0b11，+1；
                        m++;
                    }else{
                        m--;
                    }
                }
            }
            count++;
        }
        return count;
    }
}