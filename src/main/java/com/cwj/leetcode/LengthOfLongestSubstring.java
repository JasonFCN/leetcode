package com.cwj.leetcode;

import java.util.BitSet;


public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        char[] arr = s.toCharArray();
        BitSet bitSet = new BitSet(arr.length);
        for (char c : arr) {
            bitSet.set(c);
        }
        int max = bitSet.cardinality();

        for (int i = max; i >0; i--) {
            for (int j = 0; j <= s.length()-i; j++) {
                String sub =s.substring(j,i+j);
                char[] arr2 = sub.toCharArray();
                BitSet bitSet2 = new BitSet(arr2.length);
                for (char c : arr2) {
                    bitSet2.set(c);
                }
                if(sub.length()==bitSet2.cardinality()){
                    return sub.length();
                }
            }
            
        }
        return 0;
    }

    public static int lengthOfLongestSubstring2(String s) {
        int [] temp = new int[128];
        int last = 0, result = 0;
        for(int i = 0; i < s.length(); i++){
            last = Math.max(last, temp[s.charAt(i)]);
            temp[s.charAt(i)] = i + 1;
            result =Math.max(result, i - last + 1);
        }
        return result;
    }

    
}