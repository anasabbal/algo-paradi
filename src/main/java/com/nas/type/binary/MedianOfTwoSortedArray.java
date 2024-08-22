package com.nas.type.binary;

public class MedianOfTwoSortedArray {


    /**
     * Finds the median of two sorted arrays
     *
     * @param nums1 the first sorted array
     * @param nums2 the second sorted array
     * @return the median of the two sorted arrays
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            // ensure the first array is the smaller one
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length; // length of the first array
        int n = nums2.length; // length of the second array
        int total = m + n; // total number of elements
        int half = (total + 1) / 2; // half of the total elements

        int left = 0; // left boundary for binary search
        int right = m; // right boundary for binary search

        while (left <= right) {
            int i = (left + right) / 2; // middle index of the first array
            int j = half - i; // corresponding index in the second array

            // get the left and right partition values
            int nums1Left = getPartitionValue(nums1, i - 1, Integer.MIN_VALUE);
            int nums1Right = getPartitionValue(nums1, i, Integer.MAX_VALUE);
            int nums2Left = getPartitionValue(nums2, j - 1, Integer.MIN_VALUE);
            int nums2Right = getPartitionValue(nums2, j, Integer.MAX_VALUE);

            // check if the correct partition is found
            if (nums1Left <= nums2Right && nums2Left <= nums1Right) {
                // if the total number of elements is even
                if (total % 2 == 0) {
                    return (Math.max(nums1Left, nums2Left) + Math.min(nums1Right, nums2Right)) / 2.0;
                } else {
                    // if the total number of elements is odd
                    return Math.max(nums1Left, nums2Left);
                }
            } else if (nums1Left > nums2Right) {
                // move the search to the left
                right = i - 1;
            } else {
                // move the search to the right
                left = i + 1;
            }
        }

        throw new IllegalArgumentException("Input arrays are not valid.");
    }
    /**
     * Retrieves the value at a given partition, with boundary checks.
     *
     * @param nums the array to partition
     * @param index the index of the partition
     * @param boundaryValue the value to return if the index is out of bounds
     * @return the value at the partition or the boundary value if out of bounds
     */
    private static int getPartitionValue(int[] nums, int index, int boundaryValue) {
        return (index >= 0 && index < nums.length) ? nums[index] : boundaryValue;
    }
    public static void main(String[] args) {
        int[] nums1 = {1, 3};
        int[] nums2 = {2};

        double median = findMedianSortedArrays(nums1, nums2);
        System.out.println("The median is: " + median);
    }
}
