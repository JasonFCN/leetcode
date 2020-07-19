package com.cwj.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class TwoSum {
    public static void main(String[] args) {
        int[] arr = new int[10000];
        for (int i = 0; i < 10000-2; i++) {
            arr[i] = i;
        }
        arr[10000-4] = -3;
        arr[10000-3] = -5;
        int target = -8;
        long t1 = System.currentTimeMillis();
        test03(arr, target);
        long t2 = System.currentTimeMillis();
        System.out.println("time:" + (t2-t1));
    }
    

    public static int[] test02(int[] nums, int target){
        int min = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < min)   // 判断最大值
            min = nums[i];
        }
        if(min<0){
            for (int i = 0; i < nums.length; i++) {
                nums[i] = nums[i]-min;
            }
            target -= min*2;
        }
        BitSet bitSet = new BitSet();
        BitSet bitSet2 = new BitSet();
        int targetAvg = -1;
        if((target&1)==0){
            targetAvg = target/2;
            System.out.println("targetAvg：" + targetAvg);
        }
        
        int cfCount = 0;
        int[] cfArr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            bitSet.set(nums[i]);
            if(i!=0 && (bitSet.cardinality()+cfCount)!=i+1){
                cfArr[cfCount] = nums[i];
                cfCount++;
            }

            int j = target - nums[i];
            if(j>=0&&targetAvg!=j){
                bitSet2.set(j);
            }
            
        }
        bitSet.and(bitSet2);

        int[] result = new int[2];
        // 两个相同的数和为目标数
        boolean exit = false;
        for (int i = 0; i < cfArr.length; i++) {
            exit = targetAvg == cfArr[i];
            if(exit){
                break;
            }
        }
        if(exit){
            int num = 0;
            for (int i = 0; i < nums.length; i++) {
                if (targetAvg == nums[i]) {
                    result[num]= i;
                    num++;
                }
                if(num==2){
                    break;
                }
            }
        }else{
            int num = 0;
            for (int i = 0; i < nums.length; i++) {
                if (bitSet.get(nums[i])) {
                    result[num]= i;
                    num++;
                }
                if(num==2){
                    break;
                }
            }
        }
        return result;

    }

    public static int[] test03(int[] nums, int target){
        BitSet bitSet1 = new BitSet();
        BitSet bitSet2 = new BitSet();

        BitSet bitSet3 = new BitSet();
        BitSet bitSet4 = new BitSet();
        int[] result = new int[2];
        int[] targetNum = new int[2];
        for (int i = 0; i < nums.length; i++) {

            int n = nums[i];
            boolean b1 = n >= 0;
            if(b1){
                bitSet1.set(n);
            }else{
                bitSet2.set(-n);
            }

            int t = target - n;
            boolean b2 = t >= 0;
            if(b2){
                bitSet3.set(t);
            }else{
                bitSet4.set(-t);
            }

            boolean have = false;
            if(b2){
                have = bitSet1.get(t);
            }else{
                have = bitSet2.get(-t);
            }
            
            if(have){
                targetNum[0] = nums[i];
                targetNum[1] = target - nums[i];
                result[1] = i;
                if(targetNum[0]!=targetNum[1]){
                    break;
                }
            }
            
        }
        for (int i = 0; i < result[1]; i++) {
            if(nums[i] == targetNum[1]){
                result[0] = i;
                break;
            }
        }

        return result;
    }

    public static int[] test04(int[] nums,int target){
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i <nums.length ; i++) {
            int res = target - nums[i];
            if (map.containsKey(res))
            {
                return new int[]{map.get(res),i};
            }
            map.put(nums[i],i);

        }
        return new int[0];
    }
}