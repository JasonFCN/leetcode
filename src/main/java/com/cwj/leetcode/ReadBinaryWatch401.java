package com.cwj.leetcode;

import java.util.ArrayList;
import java.util.List;

public class ReadBinaryWatch401 {
    public static void main(String[] args) {
        System.out.println(readBinaryWatch(1));
    }

    public static List<String> readBinaryWatch(int num) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < 720; i++) {
            int h = i/60 ;
            int minu = i%60;
            if(Integer.bitCount(h) + Integer.bitCount(minu)==num){
                String m = minu < 10 ? h + ":" + "0" + minu :  h + ":" + minu;
                result.add(m);
                System.out.println(i + "-->" + m);
            }
        }
        return result;
    }
}