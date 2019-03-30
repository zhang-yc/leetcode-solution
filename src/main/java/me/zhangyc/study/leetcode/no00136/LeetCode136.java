package me.zhangyc.study.leetcode.no00136;

class Solution {
    public int singleNumber(int[] nums) {
        int r = 0;
        for (int e : nums) {
            r ^= e;
        }
        return r;
    }
}

public class LeetCode136 {
    public static void main(String[] args) {

    }
}
