package com.algo;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] index = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            index[i] = i;
        }
        this.sort(nums, index);
        int lo = 0;
        int hi = nums.length - 1;
        do {
            if (nums[lo] + nums[hi] > target) hi--;
            else if (nums[lo] + nums[hi] < target) lo++;
        } while (nums[lo] + nums[hi] != target);
        int[] re = {index[lo], index[hi]};
        return re;
    }

    public void sort(int[] nums, int[] index) {
        for (int i = 0; i < nums.length; i++) {
            index[i] = i;
        }
        for (int i = 0; i < nums.length; i++) {
            int min = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[min] > nums[j]) min = j;
            }
            switchWithIndex(nums, index, i, min);
        }
    }

    private void switchWithIndex(int[] nums, int[] index, int i, int j) {
        int temp = nums[i];
        int temp_index = index[i];
        nums[i] = nums[j];
        index[i] = index[j];
        nums[j] = temp;
        index[j] = temp_index;
    }

    public static void main(String[] args) {
        int[] nums = {4, 2, 3, 1};
        TwoSum solution = new TwoSum();
        int[] re = solution.twoSum(nums, 4);
        for (int i:re) {
            StdOut.println(i);
        }
    }
}
