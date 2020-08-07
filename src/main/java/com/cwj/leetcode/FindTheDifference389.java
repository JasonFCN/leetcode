package com.cwj.leetcode;

public class FindTheDifference389 {
    public static void main(String[] args) {
        System.out.println(findTheDifference3("abdef", "abdegf"));
        String a = "你好abc";
        String s = new String(a.getBytes());
    }
    public static char findTheDifference(String s, String t) {
        char c = 0;
        for (int i = 0; i < s.length(); i++) {
            c ^= s.charAt(i) ^ t.charAt(i);
        }
        return (char)(c ^ t.charAt(s.length()));
    }

    public static char findTheDifference2(String s, String t) {
        char c = 0;
        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();
        for (int i = 0; i < ss.length; i++) {
            c ^= ss[i] ^ tt[i];
        }
        return (char)(c ^ tt[s.length()]);
    }

    public static char findTheDifference3(String s, String t) {
        char[] c = s.concat(t).toCharArray();
        char a = 0;
        for (int i = 0; i < c.length; i++) {
            a ^= c[i];
        }
        return a;
    }
}