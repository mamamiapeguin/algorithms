package com.algo;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.io.File;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {
    public static int rank(int key, int[] a) {
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            int mid = (lo + hi)/2;
            if (key < a[mid]) {
                hi = mid - 1;
            } else if (key > a[mid]) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] whitelist = In.readInts("./algs4-data/".concat(args[0]));
        Arrays.sort(whitelist);
        try {
            File input = new File("./algs4-data/".concat(args[1]));
            Scanner sc = new Scanner(input);
            while (sc.hasNextLine()) {
                Integer key = Integer.parseInt(sc.nextLine().trim());
                if (rank(key, whitelist) == -1) {
                    StdOut.println("miss: " + key);
                } else {
                    StdOut.println("hit: " + key);
                }
            }
        } catch (Exception e) {
            StdOut.println(e.getMessage());
        }
    }
}
