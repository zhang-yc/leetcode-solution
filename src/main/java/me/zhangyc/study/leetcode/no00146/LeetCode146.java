package me.zhangyc.study.leetcode.no00146;

import java.util.HashMap;

class LRUCache {

    public static class Node {
        int key;
        int val;
        Node prev;
        Node next;
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private HashMap<Integer, Node> map;
    private Node head;
    private Node tail;
    private int capacity;
    private int size = 0;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>(capacity + 1);
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            if (node == head) {
                return node.val;
            }
            if (node == tail) {
                tail = tail.prev;
            }
            if (node.prev != null) {
                node.prev.next = node.next;
            }
            if (node.next != null) {
                node.next.prev = node.prev;
            }
            node.prev = null;
            node.next = head;
            head.prev = node;
            head = node;
            return node.val;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.val = value;
            if (node == head) {
                return;
            }
            if (node == tail) {
                tail = tail.prev;
            }
            if (node.prev != null) {
                node.prev.next = node.next;
            }
            if (node.next != null) {
                node.next.prev = node.prev;
            }
            node.prev = null;
            node.next = head;
            head.prev = node;
            head = node;
        } else {
            Node node = new Node(key, value);
            map.put(key, node);
            node.next = head;
            if (head != null) {
                head.prev = node;
            }
            head = node;
            if (tail == null) {
                tail = node;
            }
            if (size == capacity) {
                map.remove(tail.key);
                tail = tail.prev;
            } else {
                size += 1;
            }
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

public class LeetCode146 {
    public static void main(String[] args) {

    }
}
