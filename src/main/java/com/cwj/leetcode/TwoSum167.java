package com.cwj.leetcode;

import java.util.BitSet;


public class TwoSum167{
    public static void main(String[] args) {
        int[] numbers = {0,0,0,0,0,0,2,3,9,9,9};
        int target = 5;
        int[] result = twoSum(numbers, target);
        System.out.println(result[0] + "," + result[1]);
    }

    public static int[] twoSum2(int[] numbers, int target){
        int n = numbers.length;
        int l = 0;
        int r = n-1;
        while(l < r){
            if(numbers[l] + numbers[r] > target)
                r--;
            else if(numbers[l] + numbers[r] < target)
                l++;
            else
                return new int[] {l+1,r+1};
        }
        return new int[] {};
    }
    
    public static int[] twoSum(int[] numbers, int target) {
        if(numbers.length==2){
            return new int[] {1,2};
        }
        int[] numbers2 = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            numbers2[i] = target - numbers[i];
        }

        BitSet bitSet = new BitSet();
        BitSet bitSet2 = new BitSet();

        int min = Math.min(numbers[0], numbers2[numbers.length-1]);
        if(min<0){
            for (int i = 0; i < numbers.length; i++) {
                bitSet.set(numbers[i] - min);
                bitSet2.set(numbers2[i] - min);
            }
        }else{
            for (int i = 0; i < numbers.length; i++) {
                bitSet.set(numbers[i]);
                bitSet2.set(numbers2[i]);
            }
        }
        
        bitSet.and(bitSet2);
        int s = bitSet.cardinality();
        int[] result = new int[2];
        
        for (int i = 0,j = 0; i < numbers.length; i++) {
            int n = min < 0 ? numbers[i] - min : numbers[i];
            if(s==1){
                if(numbers[i]== target/2){
                    result[j] = i+1;
                    j++;
                }
            }if(s==2){
                if(bitSet.get(n)){
                    result[j] = i+1;
                    j++;
                }
            }else{
                if(bitSet.get(n)&&numbers[i]!= target/2){
                    result[j] = i+1;
                    j++;
                }
            }
            
        }
        return result;
    }
}