package com.nas.type.binary;

public class MedianOfTwoSortedArray {
    
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length){
            return findMedianSortedArrays(nums2, nums1);
        }
        int m = nums1.length;
        int n = nums2.length;
        int total = m + n;
        int half = (total + 1) / 2;

        int left = 0;
        int right = m;

        while (left <= right) {
            int i = (left + right) / 2;
            int j = half - i;

            int nums1Left = (i > 0) ? nums1[i - 1] : Integer.MIN_VALUE;
            int nums1Right = (i < m) ? nums1[i] : Integer.MAX_VALUE;
            int nums2Left = (j > 0) ? nums2[j - 1] : Integer.MIN_VALUE;
            int nums2Right = (j < n) ? nums2[j] : Integer.MAX_VALUE;

            if (nums1Left <= nums2Right && nums2Left <= nums1Right) {
                // we have found the correct partition
                if (total % 2 == 0) {
                    return (Math.max(nums1Left, nums2Left) + Math.min(nums1Right, nums2Right)) / 2.0;
                } else {
                    return Math.max(nums1Left, nums2Left);
                }
            } else if (nums1Left > nums2Right) {
                // move left
                right = i - 1;
            } else {
                // move right
                left = i + 1;
            }
        }

        throw new IllegalArgumentException("Input arrays are not valid.");
    }
    public static void main(String[] args) {
        int[] nums1 = {1, 3};
        int[] nums2 = {2};

        double median = findMedianSortedArrays(nums1, nums2);
        System.out.println("The median is: " + median);
    }
}
