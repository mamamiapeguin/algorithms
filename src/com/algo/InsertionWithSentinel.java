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
 * @date 2021/4/711:00 上午
 */
public class InsertionWithSentinel extends Sortable {

    public static void sort(Comparable[] a) {
        int N = a.length;
        int min = 0;
        for (int i = 0; i < N; i++) {
            if (less(a[i], a[min])) {
                min = i;
            }
        }
        exch(a, 0, min);
//        show(a);
        for (int i = 1; i < N; i++) {
            for (int j = i; less(a[j], a[j-1]); j--) {
                exch(a, j, i);
            }
//            show(a);
        }
    }
}
