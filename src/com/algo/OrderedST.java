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
 * @date 2021/4/134:04 下午
 */
abstract class OrderedST<Key extends Comparable<Key>, Value> {

    abstract void put(Key key, Value value);

    abstract Value get(Key key);

    void delete(Key key) {
        put(key, null);
    }

    boolean contains(Key key) {
        return get(key) != null;
    }

    boolean isEmpty() {
        return size() == 0;
    }

    abstract int size();

    abstract Key min();

    abstract Key max();

    abstract Key floor(Key key);

    abstract Key ceiling(Key key);

    abstract int rank(Key key);

    abstract Key select(int k);

    void deleteMin() {
        delete(min());
    }

    void deleteMax() {
        delete(max());
    }

    int size(Key lo, Key hi) {
        if (hi.compareTo(lo) < 0) {
            return 0;
        } else if (contains(hi)) {
            return rank(hi) - rank(lo) + 1;
        } else {
            return rank(hi) - rank(lo);
        }
    }

    abstract Iterable<Key> keys(Key lo, Key hi);

    Iterable<Key> keys() {
        return keys(min(), max());
    }
}
