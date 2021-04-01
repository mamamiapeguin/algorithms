package com.algo;

import edu.princeton.cs.algs4.StdOut;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * @author argomarz
 * @date 2021/4/13:17 下午
 */
public class QueueTest {

    @Test
    public void toBeOrNotToBe() {
        String[] input = new String[]{"to", "be", "or", "not", "to", "-", "be", "-", "-", "that", "-", "-", "-", "is"};
        Queue<String> queue = new Queue<>();
        Arrays.asList(input).forEach(word -> {
            if (word.equals("-")) {
                StdOut.println(queue.dequeue());
            } else {
                queue.enqueue(word);
            }
        });
    }
}