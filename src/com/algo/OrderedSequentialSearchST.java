/*
 * Copyright 2021 tuhu.cn All right reserved. This software is the
 * confidential and proprietary information of tuhu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tuhu.cn
 */
package com.algo;

import java.util.Iterator;

/**
 * @author argomarz
 * @date 2021/4/134:18 下午
 */
public class OrderedSequentialSearchST<Key extends Comparable<Key>, Value> extends OrderedST<Key, Value> {

    private int N = 0;

    private Node<Key, Value> head = null;

    private class Node<Key, Value> {
        Key key;
        Value value;
        Node<Key, Value> next;

        public Node(Key key, Value value, Node<Key, Value> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    @Override
    void put(Key key, Value value) {
        if (head == null) {
            head = new Node<>(key, value, null);
            N++;
        } else if (head.key.compareTo(key) > 0) {
            head = new Node<>(key, value, head);
            N++;
        } else {
            Node<Key, Value> cur = head;
            while (cur != null) {
                if (cur.key.compareTo(key) == 0) {
                    cur.value = value;
                } else if (cur.key.compareTo(key) < 0) {
                    if (cur.next == null || cur.next.key.compareTo(key) > 0) {
                        cur.next = new Node<>(key, value, cur.next);
                        N++;
                    }
                }
                cur = cur.next;
            }
        }
    }

    @Override
    Value get(Key key) {
        Node<Key, Value> cur = head;
        while (cur != null) {
            if (cur.key.compareTo(key) == 0) {
                return cur.value;
            }
            cur = cur.next;
        }
        return null;
    }

    @Override
    int size() {
        return 0;
    }

    @Override
    Key min() {
        return null;
    }

    @Override
    Key max() {
        return null;
    }

    @Override
    Key floor(Key key) {
        return null;
    }

    @Override
    Key ceiling(Key key) {
        return null;
    }

    @Override
    int rank(Key key) {
        return 0;
    }

    @Override
    Key select(int k) {
        return null;
    }

    @Override
    Iterable<Key> keys(Key lo, Key hi) {
        return null;
    }

    @Override
    Iterable<Key> keys() {
        return new Iterable<Key>() {
            @Override
            public Iterator<Key> iterator() {
                return new Iterator<Key>() {

                    private Node<Key, Value> cur = head;

                    @Override
                    public boolean hasNext() {
                        return cur.next != null;
                    }

                    @Override
                    public Key next() {
                        cur = cur.next;
                        return cur == null ? null : cur.key;
                    }
                };
            }
        };
    }
}
