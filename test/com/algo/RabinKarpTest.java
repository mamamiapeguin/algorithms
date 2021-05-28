package com.algo;

import edu.princeton.cs.algs4.StdOut;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author argomarz
 * @date 2021/5/2710:43 上午
 */
public class RabinKarpTest {

    /**
     * RM = R^(M-1) % Q
     */
    @Test
    public void testRM() {
        int M = 5;
        int R = 10;
        long Q = 997;
        long RM = 1;
        for (int i = 1; i <= M - 1; i++) {
            /**
             * Q 为较大素数，有R < Q， RM < Q，R%Q = R， RM%Q = RM
             * RM = (R%Q * RM) % Q
             */
            RM = (R * RM) % Q;
            StdOut.println(RM);
        }
    }

    @Test
    public void testHash() {
        RabinKarp rabinKarp = new RabinKarp("26535");
    }

    @Test
    public void testSearch() {
        String pat = "26535";
        String txt = "3141592653589793";
        RabinKarp rabinKarp = new RabinKarp(pat);
        StdOut.println(rabinKarp.search(txt));
    }
}