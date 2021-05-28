package com.algo;

import edu.princeton.cs.algs4.StdOut;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author argomarz
 * @date 2021/5/253:31 下午
 */
public class KMPTest {

    @Test
    public void run() {
        String pat = "ABRACADABRA";
        String txt = "AABRAACADABRAACAADABRA";
        KMP kmp = new KMP(pat);
        StdOut.println("text:    " + txt);
        int offset = kmp.search(txt);
        StdOut.print("pattern: ");
        for (int i = 0; i < offset; i++) {
            StdOut.print(" ");
        }
        StdOut.println(pat);
    }
}