package com.algo;

public class Selection extends Sortable
{
    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = i; j < N; j++) {
                if (less(a[j], a[min])) {
                    min = j;
                }
            }
//            show(a);
            exch(a, i, min);
        }
    }
}
