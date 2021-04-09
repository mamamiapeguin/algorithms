package com.algo;

import edu.princeton.cs.algs4.StdOut;

/**
 * 优先级队列和索引优先级队列的区别：二叉堆维护的是元素本身还是元素的索引
 * 索引 vs 元素 一一对应，不可变
 * 索引在二叉堆中的位置由元素大小决定/变化
 *
 * @param <Items>
 */
public class IndexMinPQ<Items extends Comparable<Items>> {
    private int N;
    /**
     * pq是索引的二叉堆数组，根据元素大小更新索引k在pq中的位置，元素本身维护在items[k]中
     */
    private int[] pq;
    /**
     * qp是pq的逆序，满足pq[qp[i]] = i，维护索引k在二叉堆数组pq中的w位置
     */
    private int[] qp;
    /**
     * items是稀疏的，并非二叉堆数组
     */
    private Items[] items;

    public IndexMinPQ(int maxN) {
        items = (Items[]) new Comparable[maxN];
        pq = new int[maxN + 1];
        qp = new int[maxN];
        for (int i = 0; i < maxN; i++) {
            qp[i] = -1;
        }
    }

    public void insert(int k, Items key) {
        N++;
        qp[k] = N;
        //将索引k加入二叉堆数组末尾
        pq[N] = k;
        //索引k是元素在keys中的位置，固定不变
        items[k] = key;
        //上浮过程会将索引k更新到二叉堆中的正确位置
        swim(N);
        show(qp);
        show(pq);
        show(items);
    }

    public void change(int k, Items key) {
        items[k] = key;
        swim(qp[k]);
        sink(qp[k]);
    }

    public boolean contains(int k) {
        return qp[k] != -1;
    }

    public void delete(int k) {
        int index = qp[k];
        exch(index, N--);
        swim(index);
        sink(index);
        items[k] = null;
        pq[N + 1] = 0;
        qp[k] = -1;
        show(qp);
        show(pq);
        show(items);
    }

    public Items min() {
        return items[pq[1]];
    }

    public int minIndex() {
        return pq[1];
    }

    public int delMin() {
        int indexOfMin = pq[1];
        exch(1, N--);
        sink(1);
        items[pq[N + 1]] = null;
        qp[pq[N + 1]] = -1;
        return indexOfMin;
    }

    public boolean isEmpty() {
        return 0 == N;
    }

    public int size() {
        return N;
    }

    private boolean less(int i, int j) {
        //pq是元素在二叉堆里的索引
        return items[pq[i]].compareTo(items[pq[j]]) < 0;
    }

    private void exch(int i, int j) {
        //通过交换索引等效实现交换元素
        int t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
        qp[pq[i]] = i;
        qp[pq[j]] = j;
    }

    private void swim(int k) {
        while (k > 1 && less(k, k/2)) {
            exch(k / 2, k);
            k = k / 2;
        }
    }

    private void sink(int k) {
        while (2 * k < N) {
            int j = 2 * k;
            if (j < N && less(j, j + 1)) {
                j++;
            }
            if (!less(j, k)) {
                break;
            }
            exch(k, j);
            k = j;
        }
    }

    static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            StdOut.print(a[i] + " ");
        }
        StdOut.println();
    }

    static void show(int[] a) {
        for (int i = 0; i < a.length; i++) {
            StdOut.print(a[i] + " ");
        }
        StdOut.println();
    }
}
