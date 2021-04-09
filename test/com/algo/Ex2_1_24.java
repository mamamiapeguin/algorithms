/*
 * Copyright 2021 tuhu.cn All right reserved. This software is the
 * confidential and proprietary information of tuhu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tuhu.cn
 */
package com.algo;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import org.junit.Test;

/**
 * @author argomarz
 * @date 2021/4/711:07 上午
 */
public class Ex2_1_24 {

    @Test
    public void compare() {
        String alg1 = "Insertion";
        String alg2 = "InsertionWithSentinel";
        int N = 1000;
        int T = 5;
        double t1 = SortCompare.timeRandomInput(alg1, N, T);
        double t2 = SortCompare.timeRandomInput(alg2, N, T);
        StdOut.printf("For %d random Doubles\n %s is", N, alg1);
        StdOut.printf(" %.1f times faster than %s\n", t2/t1, alg2);
    }
}
