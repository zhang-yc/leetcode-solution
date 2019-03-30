package me.zhangyc.study.leetcode.no00173;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class BSTIterator {

    public class StackItem {
        TreeNode node;
        StackItem prev;
    }

    StackItem stack;

    public BSTIterator(TreeNode root) {
        push(root);
    }

    private void push(TreeNode node) {
        while (node != null) {
            StackItem item = new StackItem();
            item.node = node;
            item.prev = this.stack;
            this.stack = item;
            node = node.left;
        }
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        if (this.stack != null) {
            TreeNode node = this.stack.node;
            this.stack = this.stack.prev;
            push(node.right);
            return node.val;
        } else {
            return 0;
        }
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return this.stack != null;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */

public class LeetCode173 {
    public static void main(String[] args) {
        TreeNode node7 = new TreeNode(7);
        TreeNode node3 = new TreeNode(3);
        TreeNode node15 = new TreeNode(15);
        TreeNode node9 = new TreeNode(9);
        TreeNode node20 = new TreeNode(20);
        node7.left = node3;
        node7.right = node15;
        node15.left = node9;
        node15.right = node20;

        BSTIterator iterator = new BSTIterator(node7);
        System.err.println(iterator.next());    // 返回 3
        System.err.println(iterator.next());    // 返回 7
        System.err.println(iterator.hasNext()); // 返回 true
        System.err.println(iterator.next());    // 返回 9
        System.err.println(iterator.hasNext()); // 返回 true
        System.err.println(iterator.next());    // 返回 15
        System.err.println(iterator.hasNext()); // 返回 true
        System.err.println(iterator.next());    // 返回 20
        System.err.println(iterator.hasNext()); // 返回 false
    }
}
