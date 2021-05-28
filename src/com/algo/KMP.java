/*
 * Copyright 2021 tuhu.cn All right reserved. This software is the
 * confidential and proprietary information of tuhu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tuhu.cn
 */
package com.algo;

/**
 * Knuth-Morris-Pratt 字符串查找算法
 *
 * @author argomarz
 * @date 2021/5/252:01 下午
 */
public class KMP {
    private String pat;
    private int[][] dfa;

    public KMP(String pat) {
        this.pat = pat;
        int M = pat.length();
        int R = 256;
        dfa = new int[R][M];
        dfa[pat.charAt(0)][0] = 1;
        for (int X = 0, j = 1; j < M; j++) {
            /**
             * 1. 复制匹配失败情况下的值
             */
            for (int c = 0; c < R; c++) {
                dfa[c][j] = dfa[c][X];
            }
            /**
             * 2. 设置匹配成功情况下的值
             */
            dfa[pat.charAt(j)][j] = j + 1;
            /**
             * 3. 更新重启状态
             * X为重启状态，由pat.charAt(1)至pat.chatAt(j - 1)匹配获得，从状态X = 0开始迭代
             * 与1，2无关
             */
            X = dfa[pat.charAt(j)][X];
        }
    }

    public int search(String txt) {
        int i, j, N = txt.length(), M = pat.length();
        for (i = 0, j = 0; i < N && j < M; i++) {
            int charAt = txt.charAt(i);
            j = dfa[txt.charAt(i)][j];
        }
        if (j == M) {
            /**
             * 找到匹配，到达模式字符串的结尾
             */
            return i - M;
        } else {
            /**
             * 未找到匹配，到达文本字符串的结尾
             */
            return N;
        }
    }
}
