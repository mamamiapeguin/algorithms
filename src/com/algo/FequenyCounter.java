package com.algo;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import sun.swing.BeanInfoUtils;

import java.io.File;
import java.util.Scanner;

public class FequenyCounter {
    public static void main(String[] args) {
        int minlen = Integer.parseInt(args[0]);

        ST<String, Integer> st = new ST<String, Integer>();
        try {
            File input = new File("../algs4-data/".concat(args[1]));
            Scanner sc = new Scanner(input);
            while (sc.hasNext()) {
                String word = sc.next();
                StdOut.println(word);
                if (word.length() < minlen) continue;
                if (st.contains(word)) st.put(word, 1);
                else st.put(word, st.get(word) + 1);
            }
        } catch (Exception e) {
            StdOut.println(e.getMessage());
        }

        String max = " ";
        st.put(max, 0);
        for (String word : st.keys()) {
            if (st.get(word) > st.get(max)) {
                max = word;
            }
        }
        StdOut.println(max + " " + st.get(max));
    }
}
