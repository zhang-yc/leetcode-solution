package me.zhangyc.study.leetcode.no00002;

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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = null;
        ListNode current = null;
        int remainder = 0;
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                remainder += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                remainder += l2.val;
                l2 = l2.next;
            }
            ListNode temp = new ListNode(remainder % 10);
            remainder /= 10;
            if (current != null) {
                current.next = temp;
                current = temp;
            } else {
                result = temp;
                current = temp;
            }
        }
        if (remainder > 0) {
            ListNode temp = new ListNode(remainder % 10);
            if (current != null) {
                current.next = temp;
                current = temp;
            } else {
                result = temp;
                current = temp;
            }
        }
        return result;
    }
}

public class LeetCode2 {

    public static void main(String[] args) {

    }
}
