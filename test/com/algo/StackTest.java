package com.algo;

import edu.princeton.cs.algs4.StdOut;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * @author argomarz
 * @date 2021/4/12:57 下午
 */
public class StackTest {

    @Test
    public void itWasTheBestOfTimes() {
        String[] input = new String[]{"it", "was", "-", "the", "best", "-", "of", "times", "-", "-", "-", "it", "was", "-", "the", "-", "-"};
        Stack<String> stack = new Stack<>();
        Arrays.asList(input).forEach(word -> {
            if (word.equals("-")) {
                StdOut.println(stack.pop());
            } else {
                stack.push(word);
            }
        });
    }
}