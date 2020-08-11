package com.cwj.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation784 {
    public static void main(String[] args) {
        char a = 'A';
        a ^= (1 << 5);
        System.out.println(a);
        System.out.println(letterCasePermutation("1bc3a4"));
    }

    public static List<String> letterCasePermutation(String S) {
        List<String> result = new ArrayList<>();
        char[] arr = S.toCharArray();
        int[] indexArr = new int[arr.length];
        int l = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] >= 65){
                indexArr[l++] = i;
            }
        }
        if(l==0){
            result.add(S);
        }else{
            for (int i = 0; i < (1 << l); i++) {
                for (int j = 0; j < l; j++) {
                    if(((i >> j) & 1)==1){
                        char c = arr[indexArr[j]];
                        if(c > 90){
                            arr[indexArr[j]] = (char)(c - 32);
                        }else{
                            arr[indexArr[j]] = (char)(c + 32);
                        }
                    }
                }
                result.add(String.valueOf(arr));
                arr = S.toCharArray();
            }
        }
        return result;
    }
}