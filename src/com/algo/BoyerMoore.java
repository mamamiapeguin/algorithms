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
 * @date 2021/5/262:19 下午
 */
public class BoyerMoore {

    private int[] right;
    private String pat;

    /**
     * 计算跳跃表
     * @param pat
     */
    BoyerMoore(String pat) {
        this.pat = pat;
        int M = pat.length();
        int R = 256;
        right = new int[R];
        /**
         * 不包含在模式字符串中的字符的值为-1
         */
        for (int c = 0; c < R; c++) {
            right[c] = -1;
        }
        /**
         * 包含在模式字符串中的字符的值
         * 为其在其中出现的最右位置
         */
        for (int j = 0; j < M; j++) {
            right[pat.charAt(j)] = j;
        }
    }

    public int search(String txt) {
        int N = txt.length();
        int M = pat.length();
        int skip;
        for (int i = 0; i <= N - M; i += skip) {
            skip = 0;
            for (int j = M - 1; j >= 0; j--) {
                if (pat.charAt(j) != txt.charAt(i + j)) {
                    skip = j - right[txt.charAt(i + j)];
                    if (skip < 1) {
                        skip = 1;
                    }
                    break;
                }
            }
            /**
             * 找到匹配
             */
            if (skip == 0) {
                return i;
            }
        }
        /**
         * 未找到匹配
         */
        return N;
    }
}
