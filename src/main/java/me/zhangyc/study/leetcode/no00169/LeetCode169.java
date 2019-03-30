package me.zhangyc.study.leetcode.no00169;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>(nums.length);
        for (int i : nums) {
            if (count.containsKey(i)) {
                count.put(i, count.get(i) + 1);
            } else {
                count.put(i, 1);
            }
        }
        int a = 0;
        int c = 0;
        for (int i : nums) {
            if (count.get(i) > c) {
                c = count.get(i);
                a = i;
            }
        }
        return a;
    }
}

public class LeetCode169 {
    public static void main(String[] args) {

    }
}
