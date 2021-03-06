package com.algo;

public class Merge extends Sortable
{
    private static Comparable[] aux;

    public static void sort(Comparable[] a) {
        aux = new Comparable[a.length];
        sort(a, 0, a.length - 1);
    }

    public static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int mid = lo + (hi - lo)/2;
        sort(a, lo, mid);
        sort(a, mid + 1, hi);
        merge(a, lo, mid, hi);
    }

    // 原地归并
    public static void merge(Comparable[] a, int lo, int mid, int hi) {
        if (aux == null) {
            aux = new Comparable[hi + 1];
        }
        int i = lo, j = mid+1;

        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }

        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                // 左半用尽，取右半
                a[k] = aux[j++];
            } else if (j > hi) {
                // 右半用尽，取左半
                a[k] = aux[i++];
            } else if (less(aux[i], aux[j])) {
                // 左半当前元素小，取左半
                a[k] = aux[i++];
            } else {
                // 右半当前元素小，取右半
                a[k] = aux[j++];
            }
            show(a);
        }
    }
}
