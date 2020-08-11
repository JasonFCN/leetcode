package com.cwj.leetcode;

public class NumberOfSteps1342 {
    public static void main(String[] args) {
        System.out.println(numberOfSteps(0b100010101010101110));
        System.out.println(numberOfSteps2(0b100010101010101110));
        System.out.println(numberOfSteps3(0b100010101010101110));
    }

    public static int numberOfSteps(int num){
        int count = 0;
        while(num!=0){
            if((num&1)==0||num==1){
                count++;
            }else{
                count+=2;
            }
            num >>= 1;
        }
        return count;
    }

    /**
     * 1bit位需要多运算一步（先 -1，再位移）
     * 0bit位只需位移
     * count = 1bit的位数-1 + 总bit位 （-1 的目的是因为最后为num=1时，减一即=0）
     * @param num
     * @return
     */
    public static int numberOfSteps2(int num){
        int count = Integer.bitCount(num) - 1;
        num |= num >> 1;
        num |= num >> 2;
        num |= num >> 4;
        num |= num >> 8;
        num |= num >> 16;
        return count + Integer.bitCount(num);
    }

    public static int numberOfSteps3(int num){
        // 1 的bit位数
        int numberOfOnes = Integer.bitCount(num);
        // 总bit位数-1（从最高位1bit到最低位）
        int bitCount = 0;
        if(num != 0){
            if(num >> 16 != 0){bitCount += 16; num >>= 16;}
            // if(num >> 8 !=0){bitCount += 8; num >>= 8;}
            // if(num >> 4 !=0){bitCount += 4; num >>= 4;}
            if(num >> 2 !=0){bitCount += 2; num >>= 2;}
            if(num >> 1 !=0){bitCount += 1; num >>= 1;}
        }
        return bitCount + numberOfOnes;
    }
}