package me.zhangyc.study.leetcode.no00145;

import java.util.LinkedList;
import java.util.List;

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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        if (root == null) {
            return result;
        }

        LinkedList<Object> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Object item = stack.pop();
            if (item instanceof Integer) {
                result.add((Integer) item);
            } else {
                TreeNode node = (TreeNode) item;
                stack.push(node.val);
                if (node.right != null) {
                    stack.push(node.right);
                }
                if (node.left != null) {
                    stack.push(node.left);
                }
            }
        }
        return result;
    }
}

public class LeetCode145 {
    public static void main(String[] args) {

    }
}
