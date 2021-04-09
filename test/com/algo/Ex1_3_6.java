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
public class Ex1_3_6 {

    @Test
    public void run() {
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
