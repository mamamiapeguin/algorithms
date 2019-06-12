package com.algo;

import edu.princeton.cs.algs4.StdOut;

public class FindMedianTwoSortedArrays {
    public double findMedianTwoSortedArrays(int[] nums1, int[] nums2) {
        int N = (int) Math.floor((double) (nums1.length + nums2.length) / 2) + 1;
        int[] merged = new int[N];
        int i = 0;
        int j = 0;
        int k = 0;
        boolean is_one_finished = false;
        while ((i <= nums1.length || j <= nums2.length) && k < N) {
            if (i == nums1.length) {
                merged[k++] = nums2[j++];
            } else if (j == nums2.length) {
                merged[k++] = nums1[i++];
            } else if (nums1[i] < nums2[j]) {
                merged[k++] = nums1[i++];
            } else {
                merged[k++] = nums2[j++];
            }
            for (int e:merged) {
                StdOut.print(e);
            }
            StdOut.println("");
        }
        if ((nums1.length + nums2.length) % 2 == 0) {
            return ((double) (merged[N - 2] + merged[N - 1])) / 2;
        } else {
            return (double) merged[N - 1];
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2};
        int[] nums2 = {3,4};
        FindMedianTwoSortedArrays solution = new FindMedianTwoSortedArrays();
        double median = solution.findMedianTwoSortedArrays(nums1, nums2);
        StdOut.println(median);
    }

}
