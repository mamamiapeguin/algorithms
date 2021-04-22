package com.algo;

/**
 * 保持完美平衡关键性质：高度向上增长
 * 同2-3树一一对应，可用2-3数推导轨迹后转化为红黑数（3-节点拆分为左链接为红的2个2-节点）
 * @param <Key>
 * @param <Value>
 */
public class RedBlackBST<Key extends Comparable<Key>, Value> {
    private final static boolean BLACK = false;
    private final static boolean RED = true;
    private Node root;

    private class Node {
        private Key key;
        private Value val;
        private Node left, right;
        private int N;
        boolean color;

        public Node(Key key, Value val, int N, boolean color) {
            this.key = key;
            this.val = val;
            this.N = N;
            this.color = color;
        }
    }

    private boolean isRed(Node x) {
        if (x == null) {
            return false;
        }
        return x.color == RED;
    }

    private Node rotateLeft(Node h) {
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = 1 + size(h.left) + size(h.right);
        return x;
    }

    private Node rotateRight(Node h) {
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = 1 + size(h.left) + size(h.right);
        return x;
    }

    private void flipColors(Node h) {
        h.color = RED;
        h.left.color = BLACK;
        h.right.color = BLACK;
    }

    public int size() {
        return size(root);
    }

    private int size(Node x) {
        if (x == null) {
            return 0;
        } else {
            return x.N;
        }
    }

    public void put(Key key, Value value) {
        root = put(root, key, value);
        root.color = BLACK;
    }

    private Node put(Node h, Key key, Value val) {
        if (h == null) {
            return new Node(key, val, 1, RED);
        }
        int cmp = key.compareTo(h.key);
        if (cmp < 0) {
            h.left = put(h.left, key, val);
        } else if (cmp > 0) {
            h.right = put(h.right, key, val);
        } else {
            h.val = val;
        }

        /**
         * 新增节点（红）加在右侧，右-右/左-右，左旋
         */
        if (isRed(h.right) && !isRed(h.left)) {
            h = rotateLeft(h);
        }
        /**
         * 新增节点（红）加在左侧，左-左/右-左，右旋
         */
        if (isRed(h.left) && isRed(h.left.left)) {
            h = rotateRight(h);
        }
        /**
         * 旋转完成，左右皆红，中间节点上浮（置红）
         */
        if (isRed(h.left) && isRed(h.right)) {
            flipColors(h);
        }

        h.N = size(h.left) + size(h.right) + 1;
        return h;
    }
}
