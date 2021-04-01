/*
 * Copyright 2021 tuhu.cn All right reserved. This software is the
 * confidential and proprietary information of tuhu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tuhu.cn
 */
package com.algo;

import edu.princeton.cs.algs4.StdOut;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author argomarz
 * @date 2021/4/13:38 下午
 */
public class E13test {

    @Test
    public void a3() {
        Stack<Integer> stack = new Stack<>();
        Arrays.asList(0, 1, 2, 3, 4).forEach(stack::push);
        while (!stack.isEmpty()) {
            pop(stack);
        }
        Arrays.asList(5, 6, 7, 8, 9).forEach(stack::push);
        while (!stack.isEmpty()) {
            pop(stack);
        }
    }

    @Test
    public void b3() {
        Stack<Integer> stack = new Stack<>();
        Arrays.asList(0, 1, 2, 3, 4).forEach(stack::push);
        pop(stack);
        Arrays.asList(5, 6).forEach(stack::push);
        pop(stack);
        Arrays.asList(7, 8).forEach(stack::push);
        // pop 2 times
        pop(stack);
        pop(stack);
        // pop 3 times
        pop(stack);
        pop(stack);
        pop(stack);
        // push 9
        stack.push(9);
        while (!stack.isEmpty()) {
            pop(stack);
        }

    }

    protected static void pop(Stack stack) {
        StdOut.print(stack.pop() + " ");
    }

    @Test
    public void a6() {
        Queue<String> queue = new Queue<>();
        Arrays.asList("a","b","c","d","e","f","g").forEach(queue::enqueue);
        Stack<String> stack = new Stack<>();
        while (!queue.isEmpty()) {
            stack.push(queue.dequeue());
        }
        while (!stack.isEmpty()) {
            String c = stack.pop();
            StdOut.println(c);
            queue.enqueue(c);
        }
    }
}
