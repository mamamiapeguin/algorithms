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
 * @date 2021/4/254:31 下午
 */
public class ConnectedComponent {

    private boolean[] marked;
    /**
     * 顶点所在联通分量序号
     */
    private int[] id;
    /**
     * 联通分量数量
     */
    private int count;

    public ConnectedComponent(Graph G) {
        marked = new boolean[G.V()];
        id = new int[G.V()];
        for (int s = 0; s < G.V(); s++) {
            if (!marked[s]) {
                dfs(G, s);
                /**
                 * 在完成单个联通分量的深度优先搜索后计数+1
                 */
                count++;
            }
        }
    }

    private void dfs(Graph G, int v) {
        marked[v] = true;
        /**
         * 递归过程中联通分量数不变，可作为序号使用，标记顶点所在的联通分量
         */
        id[v] = count;
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                dfs(G, w);
            }
        }
    }

    public boolean connected(int v, int w) {
        return id[v] == id[w];
    }

    public int id(int v) {
        return id[v];
    }

    public int count() {
        return count;
    }
}
