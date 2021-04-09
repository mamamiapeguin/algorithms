/*
 * Copyright 2021 tuhu.cn All right reserved. This software is the
 * confidential and proprietary information of tuhu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tuhu.cn
 */
package com.algo;

import org.junit.runner.manipulation.Sorter;

/**
 * @author argomarz
 * @date 2021/4/711:22 上午
 */
public class InsertionNoExch extends Sortable {

    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            Comparable temp = a[i];
            int j;
            for (j = i;j > 0 && less(temp, a[j - 1]); j--) {
                a[j] = a[j - 1];
            }
            a[j] = temp;
//            show(a);
        }
    }
}
