package com.cwj.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FindRepeatedDnaSequences187 {
    public static void main(String[] args) {
        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        List<String> resutt = findRepeatedDnaSequences(s);
        System.out.println(resutt);
    }

    public static List<String> findRepeatedDnaSequences(String s) {
        Map<Character, Integer> toInt = new HashMap<>();
        toInt.put('A', 0);
        toInt.put('C', 1);
        toInt.put('G', 2);
        toInt.put('T', 3);

        int n = s.length();
        int winL = 10;
        int[] nums = new int[n];

        // 字符串转int数组
        for (int i = 0; i < nums.length; i++) {
            nums[i] = toInt.get(s.charAt(i));
        }

        Set<Integer> set = new HashSet<>();
        Set<String> result = new HashSet<>();
        int bitInt = 0;
        int mask = 1<<(20-1);
        for (int i = 0; i < n - winL + 1; i++) {
            if(i != 0){
                // 添加末两位
                bitInt <<=2;
                bitInt |= nums[i + winL - 1];

                // 移除前导2位
                bitInt &= mask;
            }else{
                for (int j = 0; j < winL; j++) {
                    bitInt <<= 2;
                    bitInt |= nums[j];
                }
            }

            if(set.contains(bitInt)){
                result.add(s.substring(i,i + winL));
            }
            set.add(bitInt);
        }
        return new ArrayList<>(result);
    }
}