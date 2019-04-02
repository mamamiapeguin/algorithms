package com.algo;

import edu.princeton.cs.algs4.In;

public class Insertion extends Sortable
{
    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            for (int j = i; j > 0 && less(a[j], a[j-1]); j--) {
                exch(a, j, j-1);
            }
//            show(a);
        }
    }

    public static void main(String[] args) {
        String[] a = In.readStrings("./algs4-data/".concat(args[0]));
        show(a);
        sort(a);
        assert isSorted(a);
        show(a);
    }
}
