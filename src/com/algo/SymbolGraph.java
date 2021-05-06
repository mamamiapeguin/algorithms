/*
 * Copyright 2021 tuhu.cn All right reserved. This software is the
 * confidential and proprietary information of tuhu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tuhu.cn
 */
package com.algo;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.ST;

/**
 * @author argomarz
 * @date 2021/5/63:48 下午
 */
public class SymbolGraph {

    /**
     * 符号名->索引
     */
    private ST<String, Integer> st;
    /**
     * 索引->符号名
     */
    private String[] keys;
    /**
     * 图
     */
    private Graph G;

    public SymbolGraph(String stream, String sp) {
        st = new ST<>();
        In in = new In(stream);

        /**
         * 构造索引
         */
        while (in.hasNextLine()) {
            String[] a = in.readLine().split(sp);
            for (int i = 0; i < a.length; i++) {
                /**
                 * 为每个不通的字符串关联一个索引
                 */
                if (!st.contains(a[i])) {
                    st.put(a[i], st.size());
                }
            }
        }

        /**
         * 构造反向索引
         */
        keys = new String[st.size()];
        for (String name : st.keys()) {
            keys[st.get(name)] = name;
        }

        G = new Graph(st.size());
        in = new In(stream);
        while (in.hasNextLine()) {
            /**
             * 将每一行的第一个顶点和该行的其他顶点相连
             */
            String[] a = in.readLine().split(sp);
            int v = st.get(a[0]);
            for (int i = 1; i < a.length; i++) {
                G.addEdge(v, st.get(a[i]));
            }
        }
    }

    public boolean contains(String s) {
        return st.contains(s);
    }

    public int index(String s) {
        return st.get(s);
    }

    public String name(int v) {
        return keys[v];
    }

    public Graph G() {
        return G;
    }

}
