package com.cwj.leetcode;

public class FindMedianSortedArrays {
    public static void main(String[] args) {
        
    }
    // 二分法
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int sum = nums1.length + nums2.length;
        int k1 = (sum+1)/2;
        int k2 = (sum+2)/2;

        if(nums1.length==0){
            return ( (double)nums2[k1] + nums2[k2])/2;
        }
        if(nums2.length==0){
            return ( (double)nums1[k1] + nums1[k2])/2;
        }

        if(k1==1){
            return ((double)nums1[0] + nums2[0])/2;
        }

        if((k1/2) <= nums1.length){

        }
        return 0.0;
    }
}