package com.algo;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class LongestPalindrome {
    public String longestPalindrome(String s) {
        int N = s.length();
        char[] char_arr = s.toCharArray();
        String longest = "";
        int start = 0;
        while (start < N) {
            int end = N - 1;
            while (start <= end) {
                if (char_arr[start] == char_arr[end]) {
                    char[] sub = Arrays.copyOfRange(char_arr, start, end + 1);
                    for (char c:sub) {
                        StdOut.print(c);
                    }
                    StdOut.println("");
                    if (this.isPalindrome(sub) && sub.length > longest.length()) {
                        longest = new String(sub);
                        continue;
                    }
                }
                end--;
            }
            start++;
        }

        return longest;
    }

    private boolean isPalindrome(char[] sample) {
        int N = sample.length;
        if (N <= 1) {
            return true;
        }
        for (int i = 0; i <= N/2; i++) {
            if (sample[i] != sample[N-1-i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LongestPalindrome solution = new LongestPalindrome();
        String result = solution.longestPalindrome("cbbd");
        StdOut.println(result);
    }
}
