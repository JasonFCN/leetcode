package com.cwj.leetcode;
/**
 * 插入。给定两个32位的整数N与M，以及表示比特位置的i与j。编写一种方法，将M插入N，使得M从N的第j位开始，到第i位结束。假定从j位到i位足以容纳M，也即若M = 10 011，那么j和i之间至少可容纳5个位。例如，不可能出现j = 3和i = 2的情况，因为第3位和第2位之间放不下M。

示例1:

 输入：N = 10000000000, M = 10011, i = 2, j = 6
 输出：N = 10001001100
示例2:

 输入： N = 0, M = 11111, i = 0, j = 4
 输出：N = 11111

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/insert-into-bits-lcci
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class InsertBits0501 {
    public static void main(String[] args) {
        int N = 0b1000100001000111111011000001101;
        int M = 0b11111000010011001001;
        int i = 11;
        int j = 31;
        System.out.println(Integer.toBinaryString(N));
        System.out.println(Integer.toBinaryString(M));
        System.out.println(Integer.toBinaryString(insertBits(N, M, i, j)));
    }

    public static int insertBits(int N, int M, int i, int j){
        int a = j==31 ? 0 : N >> (j+1) << (j+1);
        int b = M << i;
        int c = N & ((1<<i)-1);
        System.out.println(Integer.toBinaryString(a));
        System.out.println(Integer.toBinaryString(b));
        System.out.println(Integer.toBinaryString(c));
        return a| b | c;
    }
}