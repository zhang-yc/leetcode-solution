package me.zhangyc.study.leetcode.no00003;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        Set<Character> set = new HashSet<>(26);
        set.add(s.charAt(0));
        int j = 0, max = 1;
        for (int i = 1; i < s.length(); ++i) {
            if (set.contains(s.charAt(i))) {
                while (j < i && s.charAt(j) != s.charAt(i)) {
                    set.remove(s.charAt(j));
                    j += 1;
                }
                if (j < i) {
                    j += 1;
                }
            } else {
                set.add(s.charAt(i));
                max = Math.max(max, i - j + 1);
            }
        }
        return max;
    }
}

public class LeetCode3 {
    public static void main(String[] args) {

    }
}
