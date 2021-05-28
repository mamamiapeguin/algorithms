package com.algo;

import edu.princeton.cs.algs4.In;

public class Insertion extends Sortable {
    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
                exch(a, j, j - 1);
            }
//            show(a);
        }
    }

    public static void sort(String[] a, int lo, int hi, int d) {
        /**
         * 从第d个字符开始对a[lo]到a[hi]排序
         */
        for (int i = lo; i <= hi; i++) {
            for (int j = i; j > lo && less(a[j], a[j - 1], d); j--) {
                exch(a, j, j - 1);
            }
        }
    }

    private static boolean less(String v, String w, int d) {
        return v.substring(d).compareTo(w.substring(d)) < 0;
    }

    public static void main(String[] args) {
        String[] a = In.readStrings("./algs4-data/".concat(args[0]));
        show(a);
        sort(a);
        assert isSorted(a);
        show(a);
    }
}
