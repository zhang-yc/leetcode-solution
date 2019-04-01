package me.zhangyc.study.leetcode.no00025;

import org.junit.Before;
import org.junit.Test;

import java.util.StringJoiner;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }

    @Override
    public String toString() {
        return new StringJoiner(", ", ListNode.class.getSimpleName() + "[", "]")
                .add("val=" + val)
                .toString();
    }
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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        if (k <= 1) {
            return head;
        }

        ListNode last = null;
        ListNode first = null;
        ListNode prev = null;
        ListNode current = head;
        ListNode next = null;
        head = null;
        int i = 0;
        while (current != null) {
            i += 1;
            if (i == 1) {
                first = current;
            }

            next = current.next;
            current.next = prev;

            i = i % k;
            if (i == 0) {
                if (head == null) {
                    head = current;
                }
                if (last != null) {
                    last.next = current;
                }
                last = first;
            }

            prev = i == 0 ? last : current;
            current = next;
        }

        current = prev;
        prev = null;
        if (i == 0) {
            current.next = null;
        }
        while (i > 0) {
            i -= 1;
            next = current.next;
            if (i == 0) {
                if (head == null) {
                    head = current;
                }
                if (next != null) {
                    next.next = current;
                }
            }
            current.next = prev;
            prev = current;
            current = next;
        }

        return head;
    }
}

public class LeetCode25 {

    private ListNode head;
    private Solution solution = new Solution();

    @Before
    public void before() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
//        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
//        n4.next = n5;

        head = n1;
    }

    static void print(ListNode node) {
        System.err.print(node.val);
        if (node.next != null) {
            System.err.print("->");
        } else {
            System.err.println();
            return;
        }
        print(node.next);
    }

    @Test
    public void test1() {
        ListNode h = solution.reverseKGroup(head, 2);
        print(h);
    }

    @Test
    public void test2() {
        ListNode h = solution.reverseKGroup(head, 3);
        print(h);
    }

    @Test
    public void test3() {
        ListNode h = solution.reverseKGroup(head, 4);
        print(h);
    }

    @Test
    public void test4() {
        ListNode h = solution.reverseKGroup(head, 5);
        print(h);
    }

    @Test
    public void test5() {
        ListNode h = solution.reverseKGroup(head, 6);
        print(h);
    }
}
