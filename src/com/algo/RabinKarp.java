/*
 * Copyright 2021 tuhu.cn All right reserved. This software is the
 * confidential and proprietary information of tuhu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tuhu.cn
 */
package com.algo;

/**
 * 模运算性质，在每次算数操作之后取模，等价于在完成所有算数操作后将最终结果取模：
 * (a±b)%p = (a%p±b%p)%p
 * (a*b)%p = (a%p*b%p)%p
 * (a^b)%p = ((a%p)^b)%p
 * @author argomarz
 * @date 2021/5/264:42 下午
 */
public class RabinKarp {
    /**
     * 模式字符串（仅拉斯维加斯算法需要）
     */
    private String pat;
    /**
     * 模式字符串的散列值
     */
    private long patHash;
    /**
     * 模式字符串长度
     */
    private int M;
    /**
     * 一个很大的素数
     */
    private long Q;
    /**
     * 字母表大小
     */
//    private int R = 256;
    private int R = 10;
    /**
     * R ^ (M-1) % Q
     */
    private long RM;

    public RabinKarp(String pat) {
        this.pat = pat;
        this.M = pat.length();
        Q = longRandomPrime();
        RM = 1;
        for (int i = 1; i <= M - 1; i++) {
            RM = (R * RM) % Q;
        }
        patHash = hash(pat, M);
    }

    private long longRandomPrime() {
        return 997;
    }

    /**
     * 文本字符串和模式字符串的散列值一致，大概率匹配成功
     * 可添加蒙特卡洛法或拉斯维加斯法进一步验证
     * @param i
     * @return
     */
    public boolean check(int i) {
        return true;
    }

    /**
     * Horner方法，用于除留余数法计算散列值
     * @param key
     * @param M
     * @return
     */
    public long hash(String key, int M) {
        long h = 0;
        for (int j = 0; j < M; j++) {
            /**
             * 字符"0"的charAt值为48，需减去该偏移量，可对齐图5.3.15的散列值
             */
//            h = (R * h + (key.charAt(j) - 48)) % Q;
            h = (R * h + key.charAt(j)) % Q;
        }
        return h;
    }

    public int search(String txt) {
        int N = txt.length();
        long txtHash = hash(txt, M);
        /**
         * 一开始就匹配成功
         */
        if (patHash == txtHash && check(0)) {
            return 0;
        }
        /**
         * 减去第一位数字，加上最后一个数字，再次检查匹配
         */
        for (int i = M; i < N; i++) {
            /**
             * 减去第一位数字，取模
             */
            txtHash = (txtHash + Q - RM * txt.charAt(i - M) % Q) % Q;
            /**
             * 加上最后一位数字，取模
             */
            txtHash = (txtHash * R + txt.charAt(i)) % Q;
            /**
             * 找到匹配
             */
            if (patHash == txtHash) {
                if (check(i - M + 1)) {
                    return i - M + 1;
                }
            }
        }
        /**
         * 未找到匹配
         */
        return N;
    }
}
