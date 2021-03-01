package com.algo;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import org.junit.Test;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

import static org.junit.Assert.*;

/**
 * @author argomarz
 * @date 2021/3/14:51 下午
 */
public class BinarySearchTest {

    @Test
    public void rank() {
        int[] whitelist = In.readInts("algs4-data/tinyW.txt");
        Arrays.sort(whitelist);
        try {
            File input = new File("algs4-data/tinyT.txt");
            Scanner sc = new Scanner(input);
            while (sc.hasNextLine()) {
                Integer key = Integer.parseInt(sc.nextLine().trim());
                if (BinarySearch.rank(key, whitelist) == -1) {
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