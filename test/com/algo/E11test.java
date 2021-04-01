/*
 * Copyright 2021 tuhu.cn All right reserved. This software is the
 * confidential and proprietary information of tuhu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tuhu.cn
 */
package com.algo;

import edu.princeton.cs.algs4.StdOut;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Random;

/**
 * @author argomarz
 * @date 2021/3/265:13 下午
 */
public class E11test {

    @Test
    public void a() {
        Assert.assertEquals(7, (0 + 15) / 2);
    }

    @Test
    public void b() {
        System.out.println(2.0e-6 * 100000000.1);
        Assert.assertEquals(200.0, 2.0e-6 * 100000000.1, 1.0e-6);
    }

    @Test
    public void c() {
        Assert.assertEquals(true, true && false || true && true);
    }

    @Test
    public void a2() {
        Assert.assertEquals(1.618, (1 + 2.236) / 2, 1.0e-4);
    }

    @Test
    public void b2() {
        Assert.assertEquals(10.0, 1 + 2 + 3 + 4.0, 1.0e-1);
    }

    @Test
    public void c2() {
        Assert.assertTrue(4.1 >= 4);
    }

    @Test
    public void d2() {
        Assert.assertEquals("33", 1 + 2 + "3");
    }

    @Test
    public void a5() {
        double x = new Random(1L).nextDouble();
        double y = new Random(1L).nextDouble();
        if (x > 0 && x < 1L && y > 0 && y < 1L) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
    }

    @Test
    public void a6() { //Fibonacci数列
        int f = 0;
        int g = 1;
        for (int i = 0; i <= 15; i++) {
            StdOut.println(f);
            f = f + g;
            g = f - g;
        }
    }

    /**
     * @see "如何通俗易懂地讲解牛顿迭代法求开方？数值分析？ - 马同学的回答 - 知乎"
     * https://www.zhihu.com/question/20690553/answer/146104283
     */
    @Test
    public void a7() { //牛顿迭代求平方根 t = (n/t + t)/2
        double t = 3.0;
        while (Math.abs(t - 3.0 / t) > .001) {
            t = (3.0 / t + t) / 2.0;
            StdOut.printf("%.5f\n", t);
        }
    }

    @Test
    public void b7() {
        int sum = 0;
        for (int i = 1; i < 1000; i++) {
            for (int j = 0; j < i; j++) {
                sum++;
            }
        }
        StdOut.println(sum);
    }

    @Test
    public void c7() {
        int sum = 0;
        for (int i = 1; i < 1000; i *= 2) {
            for (int j = 0; j < 1000; j++) {
                sum++;
            }
        }
        StdOut.println(sum);
    }

    @Test
    public void a8() {
        System.out.println('b'); //b
        System.out.println('b' + 'c'); //197
        System.out.println((char) ('a' + 4)); //e
    }

    @Test
    public void a9() {
        int N = 9;
        String s = "";
        for (int n = N; n > 0; n /= 2) {
            s = (n % 2) + s;
        }
        System.out.println(s);
    }

    @Test
    public void a12() {
        int[] a = new int[10];
        for (int i = 0; i < 10; i++) {
            a[i] = 9 - i;
        }
        for (int i = 0; i < 10; i++) {
            a[i] = a[a[i]];
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
    }

    @Test
    public void a16() {
        System.out.println(exR1(6));
    }

    protected static String exR1(int n) {
        if (n <= 0) {
            return "";
        }
        return exR1(n - 3) + n + exR1(n - 2) + n;
    }

    @Test
    public void a18() {
        Assert.assertEquals(50, mystery(2, 25));
        Assert.assertEquals(33, mystery(3, 11));
    }

    protected static int mystery(int a, int b) {
        System.out.printf("a: %d; b: %d\n", a, b);
        if (b == 0) {
            return 0;
        }
        if (b % 2 == 0) {
            return mystery(a + a, b/2);
        }
        return mystery(a + a, b/2) + a;
    }
}
