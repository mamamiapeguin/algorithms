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
 * @date 2021/4/1310:59 上午
 */
public class ArrayST<Key, Value> implements ST<Key, Value> {

    private int size = 0;
    private Key[] keys;
    private Value[] values;

    ArrayST() {
        keys = (Key[]) new Object[1];
        values = (Value[]) new Object[1];
    }

    @Override
    public void put(Key key, Value value) {
        if (size == keys.length) {
            resize(2 * size);
        }
        int index = indexOf(key);
        if (index == -1) {
            keys[size] = key;
            values[size] = value;
            size++;
        } else {
            values[index] = value;
        }
    }

    @Override
    public Value get(Key key) {
        int index = indexOf(key);
        if (index == -1) {
            return null;
        }
        return values[index];
    }

    private int indexOf(Key key) {
        for (int i = 0; i < size; i++) {
            if (key.equals(keys[i])) {
                return i;
            }
        }
        return -1;
    }

    private void resize(int max) {
        Key[] tempKey = (Key[]) new Object[max];
        Value[] tempValue = (Value[]) new Object[max];
        for (int i = 0; i < size; i++) {
            tempKey[i] = keys[i];
            tempValue[i] = values[i];
        }
        keys = tempKey;
        values = tempValue;
    }

    @Override
    public void delete(Key key) {
        if (size > 0 && size == keys.length/4) {
            resize(keys.length/2);
        }
        int index = indexOf(key);
        if (index == -1) {
            return;
        }
        for (int i = index; i < size - 1; i++) {
            keys[i] = keys[i + 1];
            values[i] = values[i + 1];
        }
        keys[size] = null;
        values[size] = null;
        size--;
    }

    @Override
    public boolean contains(Key key) {
        return indexOf(key) != -1;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterable<Key> keys() {
        return new Iterable<Key>() {
            @Override
            public Iterator<Key> iterator() {
                return new Iterator<Key>() {
                    private int i = 0;

                    @Override
                    public boolean hasNext() {
                        return i < size;
                    }

                    @Override
                    public Key next() {
                        return keys[i++];
                    }
                };
            }
        };
    }
}
