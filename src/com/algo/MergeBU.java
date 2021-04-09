/*
 * Copyright 2021 tuhu.cn All right reserved. This software is the
 * confidential and proprietary information of tuhu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tuhu.cn
 */
package com.algo;

/**
 * @author argomarz
 * @date 2021/4/811:22 上午
 */
public class MergeBU extends Sortable {

    private static Comparable[] aux;

    public static void sort(Comparable[] a) {
        int N = a.length;
        aux = new Comparable[N];
        for (int sz = 1; sz < N; sz = sz + sz) {
            for (int lo = 0; lo < N - sz; lo += sz + sz) {
                merge(a, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, N - 1));
            }
        }
    }

    // 原地归并
    public static void merge(Comparable[] a, int lo, int mid, int hi) {
        if (aux == null) {
            aux = new Comparable[hi + 1];
        }
        int i = lo, j = mid + 1;

        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }

        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                // 左半用尽，取右半
                a[k] = aux[j++];
            } else if (j > hi) {
                // 右半用尽，取左半
                a[k] = aux[i++];
            } else if (less(aux[i], aux[j])) {
                // 左半当前元素小，取左半
                a[k] = aux[i++];
            } else {
                // 右半当前元素小，取右半
                a[k] = aux[j++];
            }
            show(a);
        }
    }

}
