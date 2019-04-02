package com.algo;

import edu.princeton.cs.algs4.In;

public class Heap extends Sortable
{
    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int k = N/2; k >= 1; k--) {
            sink(a, k, N); //通过下沉使堆有序
        }
        while (N > 1) {
            exch(a, 1, N--); //将最大值移至数组尾
            sink(a, 1, N); //除尾部外剩余子数组重新排序
        }
    }

    private static void sink(Comparable[] a, int k, int N) {
        while (2 * k < N) {
            int j = 2*k;
            if (j < N && less(a, j, j+1)) j++;
            if (!less(k, j)) break;
            exch(a, k, j);
            k = j;
        }
    }

    public static boolean less(Comparable[] a, int i, int j) {
        return a[i-1].compareTo(a[j-1]) < 0;
    }

    public static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i-1];
        a[i-1] = a[j-1];
        a[j-1] = t;
    }

    public static void main(String[] args) {
        String[] a = In.readStrings("../algs4-data/".concat(args[0]));
        show(a);
        sort(a);
        assert isSorted(a);
        show(a);
    }
}
