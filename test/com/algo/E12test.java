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

/**
 * @author argomarz
 * @date 2021/3/292:36 下午
 */
public class E12test {

    @Test
    public void a4() {
        String string1 = "hello";
        String string2 = string1;
        string1 = "world";
        StdOut.println(string1);
        StdOut.println(string2);
    }

    @Test
    public void a5() {
        String s = "Hello World";
        s.toUpperCase();
        s.substring(6, 11);
        StdOut.println(s);
    }

    @Test
    public void a6() {
        String s = "ACTGACG";
        String t = "TGACGAC";
        Assert.assertTrue(isCircularRotation(s, t));
    }

    protected static boolean isCircularRotation(String s, String t) {
        for (int i = 1; i < s.length(); i++) {
            String front = s.substring(0, i);
            String back = s.substring(i);
            if (t.equals(back + front)) {
                return true;
            }
        }
        return false;
    }

    @Test
    public void a7() {
        String s = "abcdefg";
        Assert.assertEquals("gfedcba", mystery(s));
    }

    protected static String mystery(String s) {
        int N = s.length();
        if (N <= 1) {
            return s;
        }
        String a = s.substring(0, N/2);
        String b = s.substring(N/2, N);
        return mystery(b) + mystery(a);
    }
}
