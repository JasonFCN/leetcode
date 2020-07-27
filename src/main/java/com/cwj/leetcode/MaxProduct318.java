package com.cwj.leetcode;

import java.util.HashMap;
import java.util.Map;

public class MaxProduct318 {
    
    public static void main(String[] args) {
        System.out.println(maxProduct(new String[]{"abcw","baz","foo","bar","xtfn","abcdef"}));
    }

    public static int maxProduct(String[] words) {
        Map<Integer, Integer> map = new HashMap<>();
        for (String string : words) {
            int bitmask = 0;
            for (char c : string.toCharArray()) {
                bitmask |= 1<<(c-'a');
            }
            map.put(bitmask, Math.max(map.getOrDefault(bitmask, 0), string.length()));
        }
        int max = 0;
        for (int x : map.keySet()) {
            for (int y : map.keySet()) {
                if((x & y) == 0){
                    max = Math.max(max, map.get(x) * map.get(y));
                }
            }
        }
        return max;
    }
}