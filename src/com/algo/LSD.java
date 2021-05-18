/*
 * Copyright 2021 tuhu.cn All right reserved. This software is the
 * confidential and proprietary information of tuhu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tuhu.cn
 */
package com.algo;

/**
 * 低位优先的字符串排序
 * @author argomarz
 * @date 2021/5/184:32 下午
 */
public class LSD {

    public static void sort(String[] a, int W) {
        /**
         * 通过前W个字符将a[]排序
         */
        int N = a.length;
        int R = 256;
        String[] aux = new String[N];

        /**
         * 根据d个字符用索引键计数法排序
         */
        for (int d = W - 1; d >= 0; d--) {
            /**
             * 计算出现频率
             */
            int[] count = new int[R+1];
            for (int i = 0; i < N; i++) {
                count[a[i].charAt(d) + 1]++;
            }

            /**
             * 将频率转换为索引
             */
            for (int r = 0; r < R; r++) {
                count[r+1] += count[r];
            }

            /**
             * 将元素分类
             */
            for (int i = 0; i < N; i++) {
                aux[count[a[i].charAt(d)]++] = a[i];
            }

            /**
             * 回写
             */
            for (int i = 0; i < N; i++) {
                a[i] = aux[i];
            }
        }
    }
}
