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

/**
 * @author argomarz
 * @date 2021/4/711:33 上午
 */
public class Ex2_1_25 {

    @Test
    public void run() {
        String input = "EASYQUESTION";
        Character[] characters = new Character[input.length()];
        for (int i = 0; i < input.length(); i++) {
            characters[i] = new Character(input.toCharArray()[i]);
        }
        InsertionNoExch.sort(characters);
    }

    @Test
    public void compare() {
        String alg1 = "Insertion";
        String alg2 = "InsertionNoExch";
        int N = 100;
        int T = 5;
        double t1 = SortCompare.timeRandomInput(alg1, N, T);
        double t2 = SortCompare.timeRandomInput(alg2, N, T);
        StdOut.printf("For %d random Doubles\n %s is", N, alg1);
        StdOut.printf(" %.1f times faster than %s\n", t2/t1, alg2);
    }
}
