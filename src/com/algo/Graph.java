/*
 * Copyright 2021 tuhu.cn All right reserved. This software is the
 * confidential and proprietary information of tuhu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tuhu.cn
 */
package com.algo;

import edu.princeton.cs.algs4.In;

/**
 * @author argomarz
 * @date 2021/4/222:52 下午
 */
public class Graph {

    /**
     * 顶点数目
     */
    private final int V;
    /**
     * 边的数目
     */
    private int E;
    /**
     * 邻接表
     */
    private Bag<Integer>[] adj;

    Graph(int V) {
        this.V = V;
        this.E = 0;
        /**
         * 创建邻接表
         */
        adj = (Bag<Integer>[]) new Bag[V];
        /**
         * 邻接表初始化为空
         */
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<Integer>();
        }
    }

    Graph(In in) {
        this(in.readInt());
        int E = in.readInt();
        for (int i = 0; i < E; i++) {
            int v = in.readInt();
            int w = in.readInt();
            addEdge(v, w);
        }
    }

    int V() {
        return V;
    }

    int E() {
        return E;
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
        E++;
    }

    Iterable<Integer> adj(int v) {
        return adj[v];
    }

    @Override
    public String toString() {
        String s = V() + " vertices, " + E() + " edges\n";
        for (int v = 0; v < V(); v++) {
            s += v + ": ";
            for (int w : this.adj(v)) {
                s += w + " ";
            }
            s += "\n";
        }
        return s;
    }

    public static int degree(Graph G, int v) {
        int degree = 0;
        for (int w : G.adj(v)) {
            degree++;
        }
        return degree;
    }

    public static int maxDegree(Graph G) {
        int max = 0;
        for (int v = 0; v < G.V(); v++) {
            if (degree(G, v) > max) {
                max = degree(G, v);
            }
        }
        return max;
    }

    public static double avgDegree(Graph G) {
        return 2.0 * G.E() / G.V();
    }

    public static int numberOfSelfLoops(Graph G) {
        int count = 0;
        for (int v = 0; v < G.V(); v++) {
            for (int w : G.adj(v)) {
                if (v == w) {
                    count++;
                }
            }
        }
        return count / 2;
    }
}
