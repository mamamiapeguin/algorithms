package com.algo;

import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;

public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        char[] char_arr = s.toCharArray();
        int max_no_repeat = 0;
        int start, end;
        start = end = 0;
        ArrayList no_repeat = new ArrayList();
//        Object[] longest_arr = new Object[char_arr.length];
        boolean flag = true;
        while (start < char_arr.length && end < char_arr.length) {
            // 先走end再走start，保证end比start大
            if (flag) {
                if (no_repeat.contains(char_arr[end])) {
                    no_repeat.remove(0);
                    start++;
                } else {
                    no_repeat.add(char_arr[end++]);
                }
            } else {
                if (no_repeat.contains(char_arr[start])) {
                    start++;
                } else {
                    no_repeat.add(char_arr[start++]);
                    flag = !flag;
                }
            }
            // start超过end时，校正end
            if (start > end) {
                end = start;
            }
            if (max_no_repeat < no_repeat.size()) {
//                longest_arr = no_repeat.toArray();
                max_no_repeat = no_repeat.size();
            }

            StdOut.println("\n");
            StdOut.println("max_no_repeat: " + max_no_repeat);
            StdOut.println("start: " + start + " end: " + end);
            StdOut.println("flag: " + flag);
            for (Object c:no_repeat) {
                StdOut.print(c);
            }
            StdOut.println("");
        }
//        for (Object c:longest_arr) {
//            StdOut.print(c);
//        }
//        StdOut.println("");

        return max_no_repeat;
    }

    public static void main(String[] args) {
        LengthOfLongestSubstring solution = new LengthOfLongestSubstring();
        int max = solution.lengthOfLongestSubstring( "pwwkew");
//        StdOut.println("max_no_repeat: " + max);
//        max = solution.lengthOfLongestSubstring( "aabaab!bb");
//        StdOut.println("max_no_repeat: " + max);
//        max = solution.lengthOfLongestSubstring( "aa");
//        StdOut.println("max_no_repeat: " + max);
//        max = solution.lengthOfLongestSubstring( "aab");
//        StdOut.println("max_no_repeat: " + max);
//        max = solution.lengthOfLongestSubstring( "bbtablud");
//        StdOut.println("max_no_repeat: " + max);
        max = solution.lengthOfLongestSubstring( "qrsvbspk");
        StdOut.println("max_no_repeat: " + max);
    }
}
