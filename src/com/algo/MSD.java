/*
 * Copyright 2021 tuhu.cn All right reserved. This software is the
 * confidential and proprietary information of tuhu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tuhu.cn
 */
package com.algo;

import edu.princeton.cs.algs4.StdOut;

/**
 * @author argomarz
 * @date 2021/5/185:07 下午
 */
public class MSD {

    /**
     * 基数
     */
    private static int R = 256;
    /**
     * 小数组的切换阈值
     */
    private static final int M = 0;
    /**
     * 数据分类的辅助数组
     */
    private static String[] aux;

    private static int charAt(String s, int d) {
        if (d < s.length()) {
            return s.charAt(d);
        } else {
            return -1;
        }
    }

    public static void sort(String[] a) {
        int N = a.length;
        aux = new String[N];
        sort(a, 0, N - 1, 0);
        for (String s : a) {
            StdOut.println(s);
        }
    }

    /**
     * 以第d个字符为键将a[lo]至a[hi]排序
     * @param a
     * @param lo
     * @param hi
     * @param d
     */
    private static void sort(String[] a, int lo, int hi, int d) {
        if (hi <= lo + M) {
            Insertion.sort(a, lo, hi, d);
            return;
        }

        /**
         * 计算频率
         */
        int[] count = new int[R + 2];
        for (int i = lo; i <= hi; i++) {
            int charAt = charAt(a[i], d);
            count[charAt(a[i], d) + 2]++;
        }

        /**
         * 将频率转换为索引
         */
        for (int r = 0; r < R + 1; r++) {
            count[r + 1] += count[r];
        }

        /**
         * 数据分类
         */
        for (int i = lo; i <= hi; i++) {
            aux[count[charAt(a[i], d) + 1]++] = a[i];
        }

        /**
         * 回写
         */
        for (int i = lo; i <= hi; i++) {
            a[i] = aux[i - lo];
        }

        /**
         * 递归地以每个字符为键进行排序
         */
        for (int r = 0; r < R; r++) {
            sort(a, lo + count[r], lo + count[r+1] - 1, d+1);
        }
    }
}
