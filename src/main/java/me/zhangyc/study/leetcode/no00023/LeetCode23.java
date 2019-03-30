package me.zhangyc.study.leetcode.no00023;


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    private void up(ListNode[] nodes, int size, int i) {
        while (i > 0) {
            ListNode ni = nodes[i];
            int j = (i - 1) / 2;
            ListNode nj = nodes[j];
            if (ni.val >= nj.val) {
                break;
            } else {
                nodes[i] = nj;
                nodes[j] = ni;
                i = j;
            }
        }
    }
    private void down(ListNode[] nodes, int size, int i) {
        while (i <= size / 2 - 1) {
            ListNode ni = nodes[i];
            int j = i * 2 + 1;
            ListNode nj = j < size ? nodes[j] : null;
            int k = i * 2 + 2;
            ListNode nk = k < size ? nodes[k] : null;
            if (nk != null && nj.val > nk.val) {
                j = k;
                nj = nk;
            }
            if (ni.val <= nj.val) {
                break;
            } else {
                nodes[i] = nj;
                nodes[j] = ni;
                i = j;
            }
        }
    }
    public ListNode mergeKLists(ListNode[] lists) {
        int size = 0;
        for (int i = 0; i < lists.length; ++i) {
            if (lists[i] != null) {
                lists[size] = lists[i];
                size += 1;
                up(lists, size, size - 1);
            }
        }
        ListNode root = null;
        ListNode current = null;
        while (size > 0) {
            ListNode next = new ListNode(lists[0].val);
            if (root == null) {
                root = next;
            }
            if (current == null) {
                current = next;
            } else {
                current.next = next;
                current = next;
            }
            if (lists[0].next != null) {
                lists[0] = lists[0].next;
                down(lists, size, 0);
            } else {
                size -= 1;
                if (size > 0) {
                    lists[0] = lists[size];
                    down(lists, size, 0);
                }
            }
        }
        return root;
    }
}

public class LeetCode23 {
    public static void main(String[] args) {

    }
}
