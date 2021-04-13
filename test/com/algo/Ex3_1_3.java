package com.algo;

import edu.princeton.cs.algs4.StdOut;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author argomarz
 * @date 2021/4/135:35 下午
 */
public class Ex3_1_3 {

    @Test
    public void put() {
        String input = "EASYQUESTION";
        Character[] characters = new Character[input.length()];
        for (int i = 0; i < input.length(); i++) {
            characters[i] = new Character(input.toCharArray()[i]);
        }
        OrderedSequentialSearchST<Character, Integer> st = new OrderedSequentialSearchST<>();
        for (int i = 0; i < input.length(); i++) {
            st.put(characters[i], i);
        }
        st.keys().forEach(key -> {
            StdOut.printf("%s: %s\n", key, st.get(key));
        });
    }
}