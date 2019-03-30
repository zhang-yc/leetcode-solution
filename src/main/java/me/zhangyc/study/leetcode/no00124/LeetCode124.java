package me.zhangyc.study.leetcode.no00124;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private int[] recursive(TreeNode node) {
        if (node == null) {
            return new int[]{0, Integer.MIN_VALUE};
        }
        int[] l = recursive(node.left);
        int[] r = recursive(node.right);
        int max0 = node.val;
        max0 = Math.max(max0, node.val + (l[0] > 0 ? l[0] : 0));
        max0 = Math.max(max0, node.val + (r[0] > 0 ? r[0] : 0));
        int max1 = node.val;
        max1 = Math.max(max1, l[1]);
        max1 = Math.max(max1, r[1]);
        max1 = Math.max(max1, node.val + (l[0] > 0 ? l[0] : 0) + (r[0] > 0 ? r[0] : 0));
        return new int[]{max0, max1};
    }
    public int maxPathSum(TreeNode root) {
        return recursive(root)[1];
    }
}

public class LeetCode124 {
    public static void main(String[] args) {

    }
}
