package com.cwj.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = {"aa","a"};
        System.out.println(":" + longestCommonPrefix2(strs));
    }

    public static String longestCommonPrefix2(String[] strs) {
        if(strs==null || strs.length==0){
            return "";
        }
        if(strs.length==1){
            return strs[0];
        }
        String first = strs[0];
        for (int i = 0; i < first.length(); i++) {
            char c = first.charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if(strs[j].length() <= i ||(c ^ strs[j].charAt(i))!=0){
                    return first.substring(0, i);
                }
            }
        }
        return first;
    }

    public static String longestCommonPrefix(String[] strs) {
        if(strs.length==0){
            return "";
        }
        List<String> list = new ArrayList<>(Arrays.asList(strs));
        int minLength = list.stream().mapToInt(String::length).min().orElse(0);
        if(minLength==0){
            return "";
        }
        for (int i = 0; i < minLength; i++) {
            Set<Character> set = new HashSet<>();
            for (String string : list) {
                set.add(string.charAt(i));
            }
            if(set.size() != 1){
                return list.get(0).substring(0, i);
            }
        }
        return list.get(0).substring(0, minLength);
    }
}