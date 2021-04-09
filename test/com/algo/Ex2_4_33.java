package com.algo;

import edu.princeton.cs.algs4.StdOut;
import org.junit.Test;

/**
 * @author argomarz
 * @date 2021/4/910:29 上午
 */
public class Ex2_4_33 {

    @Test
    public void run() {
        String input = "EASYQUESTION";
        Character[] characters = new Character[input.length()];
        for (int i = 0; i < input.length(); i++) {
            characters[i] = new Character(input.toCharArray()[i]);
        }
        IndexMinPQ<Character> indexMinPQ = new IndexMinPQ<>(input.length());
        for (int i = 0; i < input.length(); i++) {
            indexMinPQ.insert(i, characters[i]);
        }
        StdOut.println("+++++++++");
        for (int i = input.length() - 1; i > 0 ; i--) {
            indexMinPQ.delete(i);
        }
    }
}