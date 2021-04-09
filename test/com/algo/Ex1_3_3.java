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
 * @date 2021/4/64:54 下午
 */
public class Ex1_3_3 {

    @Test
    public void a() {
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
    public void b() {
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
}
