package com.algo;

/**
 * 优先级队列和索引优先级队列的区别：二叉堆维护的是元素本身还是元素的索引
 * @param <Key>
 */
public class IndexMinPQ<Key extends Comparable<Key>>
{
    private int N;
    private int[] pq; //pq是二叉堆数组，根据元素在二叉堆中的位置更新元素的索引k在pq中的位置，元素本身维护在keys[k]中
    private int[] qp;
    private Key[] keys; //keys是稀疏的，并非二叉堆数组

    public IndexMinPQ(int maxN) {
        keys = (Key[]) new Comparable[maxN+1];
        pq = new int[maxN+1];
        qp = new int[maxN+1];
        for (int i = 0; i <= maxN; i++) qp[i] = -1;
    }

    public void insert(int k, Key key) {
        N++;
        qp[k] = N;
        pq[N] = k; //将索引k加入二叉堆数组末尾
        keys[k] = key; //索引k是元素在keys中的位置，固定不变
        swim(N); //上浮过程会将索引k更新到二叉堆中的正确位置
    }

    public void change(int k, Key key) {
        keys[k] = key;
    }

    public boolean contains(int k) {
        return qp[k] != -1;
    }

    public void delete(int k) {
        exch(k, N--);
        swim(k);
        sink(k);
        keys[k] = null;
        qp[k] = -1;
    }

    public Key min() {
        return keys[pq[1]];
    }

    public int minIndex() {
        return pq[1];
    }

    public int delMin() {
        int indexOfMin = pq[1];
        exch(1, N--);
        sink(1);
        keys[pq[N+1]] = null;
        qp[pq[N+1]] = -1;
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
        return keys[pq[i]].compareTo(keys[pq[j]]) < 0;
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
        while (k > 1 && less(k/2, k)) {
            exch(k/2, k);
            k = k/2;
        }
    }

    private void sink(int k) {
        while (2*k < N) {
            int j = 2*k;
            if (j < N && less(j, j+1)) j++;
            if (!less(k, j)) break;
            exch(k, j);
            k = j;
        }
    }
}
